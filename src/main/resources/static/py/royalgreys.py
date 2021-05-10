import webbrowser
import time
import subprocess

print('Opening royal greys application . . .')
subprocess.call([r"C:\Program Files\BraveSoftware\Brave-Browser\Application\brave.exe"])
time.sleep(10)

url = 'http://localhost:8080/royalgreys'

webbrowser.open(url)