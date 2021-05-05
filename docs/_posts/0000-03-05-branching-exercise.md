## Exercise prep: add a collaborator

* You are going to work in pairs
* Both need to push to the same repository
* Need to add the other person as a collaborator
    * Click Settings in your forked repository on GitHub
    * Choose ‘Collaborators & teams’
    * Add your partner

--

## Exercise: Make changes on branches

* Work in pairs, ___***SHARE THE SAME GIT REPOSITORY***___
* Create two branches based on the same start point
  * `git checkout -b branch_to_create`
* One person implements Story 2
* One person implements Story 3
* Both add to your TaxCalculator implementation with regular commits
* Merge branches back to master one by one
* Check Travis after each push

Notes:
See branch ```petrol_tax``` for a starting point to this exercise if they haven't completed the previous one.  
N.B. don't get them to checkout the branch (git weirdness will ensue), just get them to copy-paste the working code.  
There are already test suites for these stories they just need to be enabled so the build runs them.  

--

## Reflection

* What happened?
* Did you have any failed builds? If so, why?
* Did your changes conflict?

Note: Laptops closed.  
  These were very small changes.  
  Some changes last days… weeks…

--

<img src="images/merge.png">

Note: Created two branches  
  Merged diesel into master  
  Merged master into alternate  
  Merged alternate into master  

---

<img height="600" src="https://wac-cdn.atlassian.com/dam/jcr:61ccc620-5249-4338-be66-94d563f2843c/05%20(2).svg?cdnVersion=kv">

Note: Git Flow: another branch based workflow  

---

# Day One Feedback

Ten responses

--

## You liked…

+ Practical examples of merge conflicts and branching / CI
+ Help and patience from teachers and mentors
+ Horizontal diagrams and understanding merge commits
+ Finding out what Continuous Deployment means
+ Getting set up before-hand

--

## Things that could be better

+ Travis exercise was vague
+ Git is hard video
+ Some slides moved too fast
+ More advanced git and common git gotchas
+ PDF boot camp notes
+ More complex CI/CD scenarios, and deployment

--

## We liked…

+ You were punctual
+ You got stuck in with git
+ You helped each other
+ You made some good suggestions for content