from github import Github

print("enter your username")
username = input()
print("password")
password = input()
g = Github(username)
user = g.get_user()
print(user)
for repo in g.get_user().get_repos():
    print(repo.name)
