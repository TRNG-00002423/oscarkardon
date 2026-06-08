try: 
    file=open("abc.txt", "r")
    content = file.read()
    print(content)
    file.close()
except FileNotFoundError as e:
    print(e)
