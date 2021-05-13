## Understanding some Git terms

+ Git’s lingo is confusing
+ Shout out git words that we know…
+ We’ll explain some of the terms to help

--

## Commit

+ What is a commit in git?
  + Identifier (commit hash)
  + Some content
  + Message (how content changed)
  + References to parent commit(s)
  + Author
  + Authoring date (when originally committed)
  + Commit date (might be altered if commit changes)
+ When would a commit have two parents?

--

## Commit hash

+ Identifier for a single commit
+ Hex value representing an SHA-1 checksum of your commit
  + Hash of the above fields, including a hash of all the content
+ Often abbreviated: `a18d33c810d99b142d1e71cc46eab80231a5b462` becomes `a18d33c`
+ What is the commit hash of the last commit to our repo?
  + `git log`

--

## Stage (verb)

+ Stage files by using `git add`
+ Indicates the contents of the next commit

--

## HEAD

+ `HEAD` is a pointer to the commit at the tip of your current branch
  + What is `HEAD~1`?
  + What is `HEAD~2`?

--

## Working copy

+ A copy of the repository
+ Contains much (if not all) of the history of the repository
+ What is the difference between working copy and repository?

--

## Remote

+ A reference to a remote working copy
+ Might be a repo on github.com
+ Might be somewhere else
+ Remotes have names and addresses
  + What is origin?
  + What other remote names do we know?

--

## Fork (verb)

+ This is not a git term
+ When someone creates a linked working copy of a repo
+ A fork (noun) refers to the linked working copy 

--

## Clone

+ This is a git term!
+ How does cloning differ from forking? 
  + Creates an **unlinked** working copy from a remote
  + The new working copy is **local**

--

## Checkout

+ Switch current branch
+ Not to be confused with Subversion’s checkout command which fetches changes
+ Can create new branch in the process using `-b`
  ```
  git checkout master
  git checkout -b new-branch
  ```

--

## Fetch vs Pull

+ Fetch retrieves but does not apply changes (from a remote)
+ Pull fetches AND merges by default
  + With `--rebase` it rebases instead of merging

## Quick quiz

--

## What is HEAD?

- A remote
- A branch
- A commit
- A tag
- A toilet

Note: (A reference to) a commit

--

## What git command creates a branch?

- `branch`
- `checkout`
- `fork`

Note: `checkout (-b)`

--

## What hash function does a commit hash use?

- MD5
- SHA-1
- SHA-256
- Modulus 11

Note: SHA-1

--

## What does **not** go into the hash?

- Commit message
- Your code
- Remote address
- Your name
- Your email address
- Parent commit
- Soap

Note: remote address

---

## Using Git is hard

+ It is hard to know how to fix things
+ We *all* get stuck from time to time
+ Useful resources can help you when you are stuck
+ Good to practice some of the techniques

---

## Fixing mistakes

--

## [Git Pretty](http://justinhileman.info/article/git-pretty/)

<img src=http://justinhileman.info/article/git-pretty/git-pretty.png>  <!-- .element width="50%" -->

--

## [Dangit, Git!?!](https://dangitgit.com/)

Written site with more detailed instructions about how to resolve problems

<img src=images/dangitgit.png>  <!-- .element width="50%" -->

--

## [Atlassian tutorial](https://www.atlassian.com/git/tutorials/undoing-changes)

Super long word documentation with lots of explanation about how to undo stuff

--

<background>https://i.pinimg.com/originals/bf/c6/3a/bfc63af24e16b3d8103ddae2e60085c5.gif</background>
<backgroundimageopacity>0.5</backgroundimageopacity>

## All that said… 

Sometimes it is easier to start again

`rm -rf apprentice-boot-camp-fundamentals-3`  
`git clone https://github.com/MCR-Digital/apprentice-boot-camp-fundamentals-3.git`

Notes: It can be slower to fix it properly, but it can be an opportunity to learn too—balance learning and progress

--

## Scenario

+ Your tests are failing
+ When you committed the tests were passing
+ You’ve no idea how to get them working
+ You committed quite a long time ago
+ What does ‘[git pretty](http://justinhileman.info/article/git-pretty/)’ say you should do?
  + `git reset --hard`

--

## Reset

+ Takes a commit, but this defaults to current HEAD
+ Changes the value of HEAD to specified commit and unstages files
  ```
  git reset
  ```
+ Can throw away local changes too, if we tell it to
  ```
  git reset --hard
  git reset --hard HEAD~1
  ```

--

## Scenario

+ You just committed (yay)
+ You forgot to update the message (boo)
+ You realised before you pushed your changes (yay)
+ What does ‘[git pretty](http://justinhileman.info/article/git-pretty/)’ say you should do?
  + `git commit --amend`
+ What if we forgot to add a new file?
  + `git add {file}`
  + `git commit --amend`

--

## Amend your last commit

+ Amend changes (replaces) the last commit
+ Why is it replacing the last commit?
  + Commits are immutable
+ The previous commit is not actually removed
+ What happens to `HEAD`?
+ Most often used to change the message
```
git commit --amend -m "Add new message here"
```

--

## Add to your last commit

+ Staging files before amending allows you to change the contents
+ You don’t have to change the message

```
git add .
git commit --amend --no-edit
```

--

<!-- .slide: style="font-size: 80%" -->

## Detached HEAD 🤯

```
You are in 'detached HEAD' state. You can look around, make experimental
changes and commit them, and you can discard any commits you make in this
state without impacting any branches by switching back to a branch.

If you want to create a new branch to retain commits you create, you may
do so (now or later) by using -c with the switch command. Example:

  git switch -c <new-branch-name>

Or undo this operation with:

  git switch -

Turn off this advice by setting config variable advice.detachedHead to false

```

--

## Reattaching your HEAD 💆🏻

+ `git checkout` usually used to switch branches
+ Also accepts commit hashes
  + `HEAD` no longer points to the tip of a branch
+ Why might you checkout a commit?
  + Look at some code
  + Try running the tests
  + Create a branch from a historical commit
+ Reattach `HEAD` by checking out your branch again
  ```
  git checkout master
  git checkout my-branch
  ```

--

## Quick quiz

--

## What git command changes the last commit message?

- `checkout`
- `apply`
- `log`
- `amend`
- `add`
- `yolo`

Note: amend  

--

## How would you use git to restore changed tracked files to their last committed state

- `git revert`
- `git revert --soft`
- `git reset --hard`
- `git reset --hard HEAD~1`
- `rm -rf`

Note: git revert --hard  

--

## How do you get out of detached head mode?

- Following the advice in your terminal
- `git reset --hard`
- `git checkout`
- `git checkout master`
- `git reset --hard HEAD`
- `git branch bug-fix`
- `git staple neck`

Note: git revert --hard  

---

<!-- .slide: style="font-size: 80%" -->

## Exercise: git reset

1. In Terminal / Powershell, run ‘`cd exercises\git\reset`’
1. Run ‘`./setup.sh`’ / ‘`./setup.ps1`’ then ‘`cd exercise`’
1. You can run ‘`cd ..`’ and go back to step 2 to start over at any point
* Using [docs](https://git-scm.com/docs/git-reset), try to do these steps in order with single commands:
  1. Move HEAD to commit ‘9’, leaving file ‘`10.txt`’ being staged for commit
  1. Move to commit ‘8’, leaving files ‘`9.txt`’ and ‘`10.txt`’ being untracked
  1. Move to commit ‘7’, leaving ***only*** files ‘`9.txt`’ and ‘`10.txt`’ being untracked

Hint: use ‘`git status`’ and ‘`git log --oneline`’ to check progress

--

<!-- .slide: style="font-size: 80%" -->

## Exercise: git commit --amend

1. In Terminal / Powershell, run ‘`cd exercises\git\amend`’
1. Run ‘`./setup.sh`’ / ‘`./setup.ps1`’ then ‘`cd exercise`’
1. You can run ‘`cd ..`’ and go back to step 2 to start over at any point
* Using [docs](https://git-scm.com/docs/git-commit#Documentation/git-commit.txt---amend), try to do these steps in order with single commands:
  1. Examine the most recent commit using ‘`git log -p`’
  1. Amend the commit to include file ‘`bar.txt`’ without changing the message (two commands)
  1. Examine the most recent commit using ‘`git log -p`’
  1. Change the previous message

Hint: use ‘`git status`’ and ‘`git log --oneline`’ to check progress

--

<!-- .slide: style="font-size: 80%" -->

## Exercise: detached head

1. In Terminal / Powershell, run ‘`cd exercises\git\detached-head`’
1. Run ‘`./setup.sh`’ / ‘`./setup.ps1`’ then ‘`cd exercise`’
1. You can run ‘`cd ..`’ and go back to step 2 to start over at any point
1. Read the message you got, then try to do these steps in order with single commands:
  1. Reattach HEAD to the tip of the master branch
  1. Detach the HEAD from the branch and look at commit ‘B’
  1. Create a new branch called ‘`mirror`’ and switch to it
  1. Create a file called mirrorfile
  1. Commit to the new branch

Hint: use ‘`git status`’ and ‘`git log --oneline --graph --all`’ to investigate

--

## Fixing more mistakes

--

## Scenario

+ You pushed some changes
+ One of your changes caused tests to fail in the pipeline
+ You aren’t convinced you can quickly fix the test
+ You want to reverse what you did
+ What does ‘[git pretty](http://justinhileman.info/article/git-pretty/)’ say you should do?
  + `git revert {commit-hash}`

--

## Revert

+ Creates a new commit which negates a previous commit
```
git revert a18d33c
git revert HEAD~1
```
+ Old commit is still there in the history
+ You can always revert your revert

--

## Scenario

+ Your team uses branches and pull requests for code reviews
+ You made a change and committed it (yay)
+ You forgot to create a branch first (boo)
+ What does ‘[Dangit, Git!?!](https://dangitgit.com/)’ say you should do?
  ```
  git branch some-new-branch-name
  git reset HEAD~ --hard
  git checkout some-new-branch-name
  ```

--

## Scenario

+ You made a change and committed it
+ You forgot that yesterday you were working on a branch, and you didn’t switch to master before making your change
+ You want to move your changes to master
+ What does ‘[Dangit, Git!?!](https://dangitgit.com/)’ say you should do?
  ```
  git reset HEAD~ --soft
  git stash
  git checkout master
  git stash pop
  git add .
  git commit -m "New message"
  ```

Note: That’s complicated, so let’s go through it  

--

## What does reset do?

--

## Stashing your work

+ A bit like sticking stuff on the clipboard, like scratch commits
+ But… stashes go on a stack (FILO)
+ Push and pop things from the stack of stashes
  ```
  git stash
  git stash push -m "Some useful name"
  git stash list
  git stash pop
  ```

--

## Move changes to correct branch

For when you are forgetful, and commit changes to master when your team uses branches.

```
# undo the last commit, but leave the changes available
git reset HEAD~ --soft
git stash
# move to the correct branch
git checkout name-of-the-correct-branch
git stash pop
git add . # or add individual files
git commit -m "your message here";
# now your changes are on the correct branch
```

--

## Scenario

+ You started a new branch, made some changes, and want to push it
+ You run `git push` and you get:
  ```
  fatal: The current branch dummy-branch has no upstream branch.
  To push the current branch and set the remote as upstream, use
  git push --set-upstream origin dummy-branch
  ```
+ What do you need to do?
  + Read the error message!

--

## Tracking remote branches

+ New local branches don’t automatically track remote branches
+ Possible to have a working copy with branches from multiple remotes
  ```
  git push -u <remote> <branch>
  git push --set-upstream <remote> <branch>
  ```

--

## Quick quiz

--

## What is a stash?

- A commit that doesn’t belong to a branch
- Saved changes that don’t belong to a commit
- Contents which will belong to the next commit
- Something that is best cut away before anyone sees

--

## How do you track a remote branch?

- `git set-upstream <remote> <branch>`
- `git push --set-upstream <remote> <branch>`
- `git push --u <remote> <branch>`
- `git push <remote> <branch>`

--

<!-- .slide: style="font-size: 80%" -->

## Exercise: git revert

1. In Terminal / Powershell, run ‘`cd exercises\git\basic-revert`’
1. Run ‘`./setup.sh`’ / ‘`./setup.ps1`’ then ‘`cd exercise`’
1. You can run ‘`cd ..`’ and go back to step 2 to start over at any point
* Using [docs](https://git-scm.com/docs/git-revert), try to do these steps in order with single commands:
  1. Create a new commit which reverses the last commit
  1. Create a new commit which reverses the commit which added credentials

Hint: use ‘`git status`’ and ‘`git log --oneline`’ to check progress

--

<!-- .slide: style="font-size: 80%" -->

## Exercise: git stash

1. In Terminal / Powershell, run ‘`cd exercises\git\basic-stashing`’
1. Run ‘`./setup.sh`’ / ‘`./setup.ps1`’ then ‘`cd exercise`’
1. You can run ‘`cd ..`’ and go back to step 2 to start over at any point
1. Using [docs](https://git-scm.com/docs/git-stash), try to do these steps in order with single commands:
  1. Stash the work in progress (a mixture of staged/unstaged changes)
  1. Fix typos in bug.txt and commit (two steps)
  1. Restore stashed changes without removing from the stack, resulting in a mixture of staged/unstaged changes again

Hint: use ‘`cat greeting.txt`’, ‘`git status`’ and ‘`git log --oneline`’ to check progress

--

## Exercise

+ Create new local branch of this repository:
  `apprentice-boot-camp-fundamentals-3`
    ```
    git checkout -b tracking-test
    ```
+ Check tracking branches: 
    ```
    git branch -vv
    ```
+ Try to push: 
    ```
    git push
    ```
+ Push and set upstream: 
    ```
    git push -u origin tracking-test
    ```
+ Check tracking branches again

---

## Rebase vs Merge

+ Can of worms
+ Sorry, not sorry
+ Cause of most problems with git

--

(feature is current branch)  
`git merge master`

<img src=https://wac-cdn.atlassian.com/dam/jcr:e229fef6-2c2f-4a4f-b270-e1e1baa94055/02.svg?cdnVersion=766><!-- .element width="75%" -->

--

## git merge

+ Merge creates special commit with two parents
+ Joins two branches
+ No commits were destroyed in the making of this commit… history is preserved
+ Some people see extra commits as pollution

--

`git rebase master feature`

<img src=https://wac-cdn.atlassian.com/dam/jcr:5b153a22-38be-40d0-aec8-5f2fffc771e5/03.svg?cdnVersion=766>  <!-- .element width="75%" -->

--

## git rebase

+ No extra commits
+ Reattaches your branch to the tip of another branch
+ Rebasing locally results in linear history
+ Changes history

--

<background>https://24.media.tumblr.com/8e09bcd941594205f9cb42f1821c1743/tumblr_mrwjtemvHR1qfr6udo1_500.gif</background>
<backgroundimageopacity>0.5</backgroundimageopacity>

> … the encounter could create a time paradox, the results of which could cause a chain reaction that would unravel the very fabric of the space time continuum, and destroy the entire universe!
> Doc Brown—Back to the Future Part II

--

<img src=https://wac-cdn.atlassian.com/dam/jcr:1d22f018-b2c7-4096-9db1-c54940cf4f4e/05.svg?cdnVersion=766><!-- .element width="75%" -->

--

## The Golden Rule of Rebasing

***Never rebase on public branches!***

+ Possible to end up with commits appearing multiple times
+ Might not be able to push
+ Might be told you need to force push… don’t!

--

## Don’t use the `--force`!

+ Force push is destructive
+ Almost always the result of trying to get out of a previous mistake
+ Overwrites remote history
+ Breaks other peoples’ working copies
+ Only do it to your private branches
+ Might be disabled in your organisation, or just on master

--

## Quick quiz

--

## What does rebase do?

- Places incoming commits after your commits
- Fetches changes and merges them in
- Moves your commits to a new branch
- Places your commits after incoming commits
- Makes you unpopular

--

## When is it safe to force push?

- When your GitHub admins have permitted it
- When master is protected
- When no one else has a copy of the history
- When no one else has made any changes

Note: When no one else has a copy of the history

--

## Which statements about merge are true?

- Merge commits have a parent commit
- Merge will make you unpopular
- Merge changes the history
- Merging two branches results in one less branch
- Merge always creates a new commit
- Merge is one of the Bouviers

Note: will make you unpopular and always creates a new commit

---

## You want more git?!

+ [Git-it](https://github.com/jlord/git-it-electron)
  Desktop (Mac, Windows and Linux) app that teaches you how to use Git and GitHub on the command line.