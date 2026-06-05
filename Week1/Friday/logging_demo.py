import logging

print("print vs logging")
print("Application Started....")
print("Something went wrong....")
print("Lets log this....")

logging.basicConfig(
    level=logging.DEBUG,
    format="%(asctime)s | %(levelname)-8s | %(message)s",
    datefmt="%H:%M:%S",
)
logging.debug("This is a DEBUG message")
logging.info("This is INFO")
logging.warning("This is a WARNING message")
logging.error("This is error message")
logging.critical("This is Critical message")