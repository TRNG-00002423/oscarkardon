"""
Trainee starter — sqlite3 contact CLI.
TODO: implement subcommands per exercise_sqlite3.md
Run: python contact_app_starter.py --help
"""

from __future__ import annotations

import argparse
import sqlite3
from pathlib import Path

DEFAULT_DB = Path(__file__).with_name("contacts.db")


def open_db(path: Path) -> sqlite3.Connection:
    conn = sqlite3.connect(path)
    conn.execute("PRAGMA foreign_keys = ON")
    conn.row_factory = sqlite3.Row
    return conn


def bootstrap(conn: sqlite3.Connection) -> None:
    conn.executescript(
        """
        CREATE TABLE IF NOT EXISTS contact (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            email TEXT NOT NULL UNIQUE
        );
        """
    )
    conn.commit()


def main() -> None:
    parser = argparse.ArgumentParser(description="Contacts (sqlite3 exercise)")
    parser.add_argument("--db", type=Path, default=DEFAULT_DB, help="SQLite database file")
    sub = parser.add_subparsers(dest="cmd", required=True)

    sub.add_parser("list", help="List contacts")

    p_add = sub.add_parser("add", help="Add contact")
    p_add.add_argument("--name", required=True)
    p_add.add_argument("--email", required=True)

    p_get = sub.add_parser("get", help="Get one contact")
    p_get.add_argument("--id", type=int, required=True)

    p_upd = sub.add_parser("update", help="Update contact")
    p_upd.add_argument("--id", type=int, required=True)
    p_upd.add_argument("--name")
    p_upd.add_argument("--email")

    p_del = sub.add_parser("delete", help="Delete contact")
    p_del.add_argument("--id", type=int, required=True)

    args = parser.parse_args()
    conn = open_db(args.db)
    bootstrap(conn)

    if args.cmd == "list":
        list_contacts(conn)
    if args.cmd == "add":
        add_contact(conn, args.name, args.email)
    if args.cmd == "get":
        get_contact(conn, args.id)
    if args.cmd == "update":
        update_contact(conn, args.id, args.name, args.email)
    if args.cmd == "delete":
        delete_contact(conn, args.id)

def list_contacts(conn):
    rows = conn.execute("SELECT * FROM contact").fetchall()
    if not rows:
        print("No contacts found.")
        return
    for row in rows:
        print(dict(row))

def add_contact(conn, name, email):
    try:
        cursor = conn.execute(
            "INSERT INTO contact (name, email) VALUES (?, ?)",
            (name, email),
        )
        conn.commit()
        print(f"New contact ID: {cursor.lastrowid}")
    except sqlite3.IntegrityError:
        print("Error: email already exists.")

def get_contact(conn, id):
    row = conn.execute("SELECT * FROM contact WHERE ID = ?", (id,)).fetchone()
    print(dict(row))

def update_contact(conn, id, name, email):
    updates = []
    values = []

    if name:
        updates.append("name = ?")
        values.append(name)

    if email:
        updates.append("email = ?")
        values.append(email)

    if not updates:
        print("Nothing to update.")
        return

    values.append(id)
    
    sql = f"UPDATE contact SET {', '.join(updates)} WHERE id = ?"
    try:
        cursor = conn.execute(sql, values)
        conn.commit()

        if cursor.rowcount == 0:
            print("not found")
        else:
            print("Contact updated.")
    except sqlite3.IntegrityError:
        print("Error: email already exists.")

def delete_contact(conn, id):
    cursor = conn.execute(
        "DELETE FROM contact WHERE id = ?",
        (id,),
    )
    conn.commit()

    if cursor.rowcount == 0:
        print("not found")
    else:
        print("Contact deleted.")

if __name__ == "__main__":
    main()