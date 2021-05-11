## Git is hard

We all get stuck from time to time

--

<background>https://i.pinimg.com/originals/bf/c6/3a/bfc63af24e16b3d8103ddae2e60085c5.gif</background>

--

## Sometimes it is easier to start again

Notes: Important to balance learning and progress

--

## [Git Pretty](http://justinhileman.info/article/git-pretty/)
<img src=http://justinhileman.info/article/git-pretty/git-pretty.png>  <!-- .element width="50%" -->

--

## Warning… incoming sweariness

--

## [Oh Shit, Git!?!](https://ohshitgit.com/)

Written site with more detailed instructions about how to resolve problems

--

## [Atlassian tutorial](https://www.atlassian.com/git/tutorials/undoing-changes)

Super long word documentation with lots of explanation about how to undo stuff

--

## Commit hash

+ Describes a commit
+ Hex value representing a checksum of your content
+ Often abbreviated: `a18d33c810d99b142d1e71cc46eab80231a5b462` becomes `a18d33c`

--

## HEAD

Head is a pointer to the tip of your current branch

`HEAD~1`, `HEAD~2`

--

## Fetch vs Pull

+ Fetch retrieves but does not apply remote changes
+ Pull fetches AND merges by default
    + With `--rebase` it rebases instead of merging

--

## Reset

Throw away local changes

```
git reset --hard
git reset --hard HEAD~1
```

--

## Amend your last commit message

```
git commit --amend -m "Add new message here"
```

--

## Add to your last commit

```
git add .
git commit --amend --no-edit
```

--

## Revert

Creates a new commit which negates a previous commit

```
git revert a18d33c
```

--

## Move changes to correct branch

In case you are forgetful, and commit changes to master when your team uses branches.

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

## Tracking remote branches

When you create a branch locally, you need to say where to push it to:

```
git push -u <remote> <branch>
git push --set-upstream <remote> <branch>
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

--

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

## [Git-it](https://github.com/jlord/git-it-electron)

Desktop (Mac, Windows and Linux) app that teaches you how to use Git and GitHub on the command line.
