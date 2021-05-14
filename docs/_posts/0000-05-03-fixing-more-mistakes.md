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

---

<!-- .slide: style="font-size: 80%" -->

## Exercise: git revert

1. In Terminal / Powershell, run ‘`cd exercises\git\basic-revert`’
1. Run ‘`./setup.sh`’ / ‘`./setup.ps1`’ then ‘`cd exercise`’
1. You can run ‘`cd ..`’ and go back to step 2 to start over at any point
* Using [docs](https://git-scm.com/docs/git-revert), try to do these steps in order with single commands:
  1. Create a new commit which reverses the last commit
  1. Find which commit added credentials
  1. Create a new commit which reverses that commit
    * Note that the credentials have disappeared from `HEAD` version

Hint: use ‘`cat greeting.txt`’, ‘`git status`’ and ‘`git log --oneline`’ to check progress

Note: [Revert Kata README](https://github.com/eficode-academy/git-katas/tree/master/basic-revert)
```
git revert HEAD
# observe result and
# find credentials commit hash
git log --oneline
git revert [credentials-commit-hash]
git log --oneline (show result)
```

--

<!-- .slide: style="font-size: 75%" -->

## Exercise: git stash

1. In Terminal/Powershell, ‘`cd exercises\git\basic-stashing`’
1. Run ‘`./setup.sh`’ / ‘`./setup.ps1`’ then ‘`cd exercise`’
1. You can run ‘`cd ..`’ and go back to step 2 to start over at any point
1. Using [docs](https://git-scm.com/docs/git-stash), try to do these steps in order with single commands:
  1. Stash the work in progress (a mixture of staged/unstaged changes)
  1. Fix typos in bug.txt and commit (two steps)
  1. Look at what stashes are available
  1. Restore stashed changes without removing from the stack, resulting in a mixture of staged/unstaged changes again
    * You’ll need to supply an option to restore the state of the index
  1. Drop your stash and check it has gone (two commands)

Hint: use ‘`git status`’ and ‘`git stash list`’ to check progress

Note: [Stash Kata README](https://github.com/eficode-academy/git-katas/tree/master/basic-stashing)
```
git stash
vi bug.txt
git commit -am "Fix typos"
git stash list
git stash apply --index
git stash drop
git stash list
```

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
- Merging two branches results in one fewer branches
- Merge always creates a new commit
- Merge is one of the Bouviers

Note: will make you unpopular and always creates a new commit

---

## You want more git?!

+ [Git-it](https://github.com/jlord/git-it-electron)
  Desktop (Mac, Windows and Linux) app that teaches you how to use Git and GitHub on the command line.