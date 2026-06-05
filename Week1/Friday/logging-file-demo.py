import logging
import logging.handlers
import os

logger = logging.getLogger("my_logger")
logger.setLevel(logging.DEBUG)

console = logging.StreamHandler()
console.setLevel(logging.INFO)
console.setFormatter(logging.Formatter("%(asctime)s | %(levelname)-8s | %(message)s"))

log_file = "my_logs.log"
file_handler = logging.FileHandler(log_file, mode="w")
file_handler.setLevel(logging.ERROR)
file_handler.setFormatter(logging.Formatter(
    fmt="%(asctime)s | %(levelname)-8s | %(message)s",
    datefmt="%H:%M:%S",
))

logger.addHandler(console)
logger.addHandler(file_handler)

logger.debug("This is a DEBUG message")
logger.info("This is INFO")
logger.warning("This is a WARNING message")
logger.error("This is error message")
logger.critical("This is Critical message")