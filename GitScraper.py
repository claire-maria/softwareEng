from github3 import login, GitHub
from getpass import getpass, getuser
from github import Github
import requests
import json
import sys

ACCESS_TOKEN = 'e1f2962d0b7b8475818f1689a711fade678f2e2'

try:
    import readline
except ImportError:
    pass

try:
    user = input('GitHub username: ')
except KeyboardInterrupt:
    user = getuser()
password = getpass('GitHub password for {0}: '.format(user))



def getRepoNames(user,password):
    g = Github(user,password)
    user = g.get_user()
    print(user)
    for repo in g.get_user().get_repos():
        print(repo.name)
        stargazers = [ s for s in repo.get_stargazers() ]
        print("Number of stargazers", len(stargazers))

getRepoNames(user,password)
