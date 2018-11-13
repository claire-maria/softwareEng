from github import Github
import json
import itertools
g = Github("ACCESS TOKEN") 

repo_names = []
commits_per_repo = []
user = g.get_user()
user.login
print("Successfully logged in user " + user.name)
print("")
print(user.name + " has the following repositories: ")
for repo in g.get_user().get_repos():
    print(repo.name)
    x = repo.name
    repo_names.append(x)
print("")
print(repo_names)

countTotal = 0
for repo in user.get_repos():
    count = 0
    if repo in user.get_repos():
        print(repo.name)
        for commit in repo.get_commits():
            print(commit.commit.author.date)
            print("")
            count += 1
            countTotal += 1
    commits_per_repo.append(count)
    print(commits_per_repo)
        

print("Total amount of commits: " + str(countTotal))


data = dict(zip(repo_names,commits_per_repo))
print(data)
with open('myData.txt', 'w') as outfile:  
    json.dump(data, outfile)

