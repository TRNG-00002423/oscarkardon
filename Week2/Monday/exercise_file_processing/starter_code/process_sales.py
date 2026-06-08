"""
Week 2 Exercise — CSV processing with context managers.

TODO:
1. Read starter_code/data/sales.csv using csv.DictReader and with open(...).
2. Compute rows count, grand total (sum of units * unit_price), average line revenue.
3. Find SKU with max line revenue (tie: first in file).
4. Write output/summary.txt using with open(..., "w", encoding="utf-8").
"""

from __future__ import annotations
import csv


def main() -> None:
    sales = []
    with open("data/sales.csv", "r") as file:
        reader = csv.DictReader(file)
        for row in reader:
            sales.append(row)

            
    rows = len(sales)
    total = sum(int(sale["units"]) * float(sale["unit_price"]) for sale in sales)    
    # print(f"Grant total: {total}")
    average = total / len(sales)
    # print(f"Average line revenue: {average}")

    max_sale = max(sales, key=lambda sale: int(sale["units"]) * float(sale["unit_price"]))
    # print(f"Max line revenuse SKU: {max_sale["sku"]}")

    with open("output/summary.txt", "w") as file:
        file.write(f"rows: {rows}\n")
        file.write(f"grand_total: {total}\n")
        file.write(f"average_line_revenue: {average:.2f}\n")
        file.write(f"top_sku: {max_sale['sku']}\n")

    

if __name__ == "__main__":
    main()