import requests

# Jenkins settings
jenkins_url = ''
username = ''
password = ''
groovy_script_path = ''

# Read the Groovy script from the file
with open(groovy_script_path, 'r') as file:
    groovy_script = file.read()

# Jenkins script endpoint
script_endpoint = f'{jenkins_url}/manage/script'

# Creating a single session
s = requests.Session()
s.auth = (username, password)

# Getting crumb for Session from jenkins as it is needed for interaction with Jenkins
crumb_json = (s.get(jenkins_url + "/crumbIssuer/api/json")).json()
crumb_value = crumb_json.get('crumb')

# Request headers
headers = {
    'Content-Type': 'application/x-www-form-urlencoded',
    "Jenkins-Crumb": crumb_value
}

# Data payload
data = {
    'script': groovy_script,
    'Submit': '',
    'Jenkins-Crumb': crumb_value
}

# Make the POST request
response = s.post(script_endpoint, headers=headers, data=data)

# Check the response
if response.status_code == 200:
    print("Script executed successfully")
    print(response.status_code)
else:
    print(f"Failed to execute script. Status code: {response.status_code}")
    print(response.text)
    print(response.status_code)
