## Continuous Delivery & Deployment

Structure:

+ What is it?
+ Why is it important?
+ How do we do it?

Note: Laptops closed.  
  Ask people what they think it means  

---

> “Continuous delivery … is a software engineering approach in which teams produce software in short cycles, ensuring that the software can be reliably released at any time and, when releasing the software, doing so manually. It aims at building, testing, and releasing software with greater speed and frequency  
> …

--

> “…  
> The approach helps reduce the cost, time, and risk of delivering changes by allowing for more incremental updates to applications in production. A straightforward and repeatable deployment process is important for continuous delivery.  
> …”

--

> “CD contrasts with continuous deployment, a similar approach in which software is also produced in short cycles but through automated deployments rather than manual ones.”  
> —<cite>[Wikipedia](https://en.wikipedia.org/wiki/Continuous_delivery)</cite>

--

> … teams produce software in short cycles …

Note: Just like our CI definition says several times a day…  
  Could be every five minutes, could be every two hours.  

--

> … ensuring that the software can be reliably released at any time …

Note: At any time means when code is pushed.  
  CI says “verified by an automated build”  
  Automated verification helps with this  
  Further: must be usable/desirable  
  Features should be complete or hidden  
  Going to focus on this  

--

> … when releasing the software, doing so manually …

Note: Manually triggering an automated process vs an automatic process.  

---

<img src="images/continous-integration-delivery-deployment.svg">

Note: Explain push from CI to CD  

---

## Why is it important?

+ Bigger deployments are riskier
+ Deploying fixes
+ Some changes require coordination
+ Unpushed code is risky

Note: Unfinished work can block releasing urgent fixes  
  Sometimes a coordinated release or business activity needs to happen  

---

## Continuous Deployment safety

--

<img src="images/continous-integration-delivery-deployment.svg">

Staying safe involves practices at each step of the journey to production.

--

## Techniques involved

+ ***Release planning***
  + How to work on multiple features at the same time
+ Automated testing
+ Automated packaging
+ Automated deployment
+ ***Deployment strategies*** (Risk mitigation)
+ Observation and support

Notes: Today talking about the highlighted points.    
  Other boot camps will cover the other parts.  

---

<backgroundimage>https://m.media-amazon.com/images/M/MV5BMTk3NzAyMjY0OF5BMl5BanBnXkFtZTgwNDQ4MTUxNTE@._V1_SY1000_SX1500_AL_.jpg</backgroundimage>
<backgroundimageopacity>0.25</backgroundimageopacity>

> Dinesh, did you deploy?  

--

<backgroundimage>https://m.media-amazon.com/images/M/MV5BN2IzYjhlOTUtMDVmMy00NTk3LTkxNjAtNDZmYjFhNzY3OWJlXkEyXkFqcGdeQXVyNjc5Mjg0NjU@._V1_SY1000_SX1500_AL_.jpg</backgroundimage>
<backgroundimageopacity>0.25</backgroundimageopacity>

> Yeah, there were some performance improvements waiting.  

--

<backgroundimage>https://m.media-amazon.com/images/M/MV5BMTk3NzAyMjY0OF5BMl5BanBnXkFtZTgwNDQ4MTUxNTE@._V1_SY1000_SX1500_AL_.jpg</backgroundimage>
<backgroundimageopacity>0.25</backgroundimageopacity>

> Did you look at what you were releasing?  

--

<backgroundimage>https://m.media-amazon.com/images/M/MV5BN2IzYjhlOTUtMDVmMy00NTk3LTkxNjAtNDZmYjFhNzY3OWJlXkEyXkFqcGdeQXVyNjc5Mjg0NjU@._V1_SY1000_SX1500_AL_.jpg</backgroundimage>
<backgroundimageopacity>0.25</backgroundimageopacity>

> Yeah… you had a commit saying you were making changes to the login process.

--

<backgroundimage>https://m.media-amazon.com/images/M/MV5BMTk3NzAyMjY0OF5BMl5BanBnXkFtZTgwNDQ4MTUxNTE@._V1_SY1000_SX1500_AL_.jpg</backgroundimage>
<backgroundimageopacity>0.25</backgroundimageopacity>

> That’s right. Making changes. So far all I’ve done is remove the old process.

--

<backgroundimage>https://m.media-amazon.com/images/M/MV5BN2IzYjhlOTUtMDVmMy00NTk3LTkxNjAtNDZmYjFhNzY3OWJlXkEyXkFqcGdeQXVyNjc5Mjg0NjU@._V1_SY1000_SX1500_AL_.jpg</backgroundimage>
<backgroundimageopacity>0.25</backgroundimageopacity>

> Dammit Gilfoyle.

---

## Smaller deployments

+ Less to test
+ Fewer suspects when investigating issues
+ Earlier visibility of problems

Note: Kinder to testers—less context to remember.  

---

## Working on multiple changes 
### Trunk vs Branch

+ Two different ways to make sure you don’t release incomplete changes
+ As usual this is a subjective issue
+ Each has pros and cons 

--

## What is a branch?

+ Formed when two commits have the same parent
+ Commits made against the branch your working copy points to

--

<img src="https://www.atlassian.com/dam/jcr:746be214-eb99-462c-9319-04a4d2eeebfa/01.svg">

Note:
Explain the diagram:
time goes left to right
circle = commit
lines are branches

--

## What is trunk?

+ Trunk is another term for master
+ It is a special branch

--

## What is a working copy?

+ Your local clone is a working copy
+ Working copy ≠ branch
+ The copy can consist of multiple branches

---

## The case for branching…


--

## Branches

+ Protect the main code-base from incomplete changes
+ Enable parallel streams of development
+ Make the history more legible

--

## Feature Branch Workflow

> “… all feature development should take place in a dedicated branch instead of the master branch. … makes it easy for multiple developers to work on a particular feature without disturbing the main codebase. It also means the master branch will never contain broken code …”
> —[Git Feature Branch Workflow](https://www.atlassian.com/git/tutorials/comparing-workflows/feature-branch-workflow)

--

## How do feature branches enable CD?

+ Nobody works on the master branch
    + thus master is always releaseable
+ Any feature-based changes made on a feature branch
+ Some Continuous Integration systems only run on master...


Note:
Mention that some people consider that not running against master isn't true CI.

--

## Example *

### Mary begins a new feature

<img src="https://wac-cdn.atlassian.com/dam/jcr:223f5106-2191-4450-8916-e5c80d7d907a/02.svg?cdnVersion=ks">

```
git checkout -b marys-feature master
```

`*` Shamelessly borrowed from [Atlassian](https://www.atlassian.com/git/tutorials/comparing-workflows/feature-branch-workflow)

--

### Mary goes to lunch

<img src="https://wac-cdn.atlassian.com/dam/jcr:e2c88c1b-fb28-46a3-93be-c1c45f86bd1c/03%20(1).svg?cdnVersion=ks">

```
git push -u origin marys-feature
```

--

### Mary finishes her feature

<img src="https://wac-cdn.atlassian.com/dam/jcr:d0c471b4-61c8-4005-86bc-904d894e391b/04.svg?cdnVersion=ks">

```
git push
```

--

### Bill receives the pull request

<img src="https://wac-cdn.atlassian.com/dam/jcr:2119c2a3-7dff-43ad-bf98-77672d93242f/05%20(1).svg?cdnVersion=ks">

--

### Mary publishes her feature

<img src="https://wac-cdn.atlassian.com/dam/jcr:09308632-38a3-4637-bba2-af2110629d56/07.svg?cdnVersion=ks">

```
git checkout master
git pull
git pull origin marys-feature
git push
```

--

## Afterwards

Delete the branch… done.

---

<img height="500" src="https://upload.wikimedia.org/wikipedia/commons/0/01/LinuxCon_Europe_Linus_Torvalds_03_%28cropped%29.jpg">

+ Linus Torvalds

--

<img src="http://upload.wikimedia.org/wikipedia/commons/a/af/Tux.png"/>

+ Father of the Linux kernel
+ Creator of git
+ Mother of...

--

> What the #*?!, guys?
> This piece-of-$#?! commit is marked for stable, but you clearly never
> even test-compiled it, did you?

> There aren't enough swear-words in the English language, so now I'll
> have to call you perkeleen vittupää just to express my disgust and
> frustration with this crap.
 
> Linus [LKML.ORG 2013](https://lkml.org/lkml/2013/7/13/132)

Note:
Allegedly he has attempted to clean up his act since

--

## Why is Linux a good example?

[gitstats for Linux kernel end of 2019](https://phoronix.com/misc/linux-eoy2019/lines.html)

+ It's not just Linux

[<img src="https://opensource.org/files/osi_keyhole_300X300_90ppi_0.png">](https://www.opensource.org)

--

> The normal git workflow involves the use of a lot of branches.
> Each line of development can be separated into a separate “topic branch” and maintained independently.
> Branches in git are cheap, there is no reason to not make free use of them.

[A Guide to the Kernel Development Process](https://www.kernel.org/doc/html/latest/process/7.AdvancedTopics.html) 

--

> ...Git is “expressly designed to make you feel less intelligent than you thought you were.” What’s your response to this?

> Torvalds: So I think it used to be true but isn’t any more. There is a few reasons people feel that way, but I think only one of them remains. The one that remains is fairly simple: “you can do things so many ways.”

[10 Years of Git](https://www.linuxfoundation.org/blog/2015/04/10-years-of-git-an-interview-with-git-creator-linus-torvalds)

--

## A prophecy...

<iframe src="https://player.vimeo.com/video/60788996" width="640" height="360" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>
<p><a href="https://vimeo.com/60788996">GIT IS HARD</a> from <a href="https://vimeo.com/owltastic">Meagan Fisher</a> on <a href="https://vimeo.com">Vimeo</a>.</p>

Note:
This video probably needs a bit of context setting - it's a developer having some issues with git which perplexes the whole team.
This situation is not uncommon ;-)
We're going to do some exercises involving branching, git is a very powerful tool, it's possible to get things VERY wrong.

--

<img style="border:0;box-shadow:none;background-color:transparent" src="images/aliens.png">

Note:
I'm increasingly of the opinion that there is only one real explanation for how git works, and that is that it is alien technology ;-)

--

<img width="500px" src="images/guitar_hero.png">

Note:
Branches can easily get out of control, they should be few in number and short-lived - you have been warned.

--

### Git guidelines

+ Use a small set of commands:
    + clone
    + commit
    + push
    + pull
+ Use a consistent workflow
+ Branches should be short-lived
+ The number of branches should be small

--

## Merging

<img src="https://wac-cdn.atlassian.com/dam/jcr:09308632-38a3-4637-bba2-af2110629d56/07.svg?cdnVersion=ks">


Note:
What is a merge
Sometimes it's easy
And sometimes it's hard

--

<backgroundimage>images/traffic_merge.svg</backgroundimage>
<backgroundimageopacity>0.25</backgroundimageopacity>

+ Git is actually good at merging
+ Some merges are simple
+ Some merges are not
+ Keeping your branches short-lived decreases the risk of complicated merges
    

--


### Different kinds of merge

* Simple
    + Different files
    + Same file, different lines
    + Same file, same lines
* Complicated

Note:
Whiteboard what might be simple and complex merges with the group

--

### Diverging branches

<img src="images/diverging_branches.svg">

+ The problem gets worse with distance and time


Note:
It's not just the change itself that determines the complexity of the merge, they get worse with distance and time.
You can end up with separate bits of software.
Like straddling two diverging canoes.


--

### A simple merge

<img src="images/green_merge.png">

+ Be a little wary

Note:
Worth pointing out that just because a merge can be completed automatically, does not guarantee the functionality is
correct.

--


### A complicated merge

<img src="images/merge_hell.png">

Note:
A salutary tale - whilst working on the slides I failed to follow my own advice and ended up with conflicts.
Explain the merge view, our changes on the left, base version in the middle, other developer's version on the right.

--

### Conflicts

```
<<<<<<< HEAD:file.txt
Conflicts
=======
What conflicts?
>>>>>>> 77976da35a11db4580b80ae27e8d65caf5208086:file.txt
```

+ Must be resolved manually
+ _**BE AFRAID!**_


Note:
What are they  
What do they look like  
What is the effect  
How do you resolve them  


---

## Exercise: Make two changes using branches

* Work in pairs, ___***share the same git repository***___
* Create two branches based on the same start point
  * `git checkout -b branch_to_create`
* One person implements Story 2 - Diesel vehicles
* One person implements Story 3 - Alternative fuel vehicles
* Add to your TaxCalculator implementation
* Merge branches back to master one by one (observe Travis in between)


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

## The case for trunk based development

+ No one likes merging
+ Everyone works on ‘master’
+ Changes regularly pushed back to origin

Note: Reminder: opinion follows  
  Still get conflicts but they are incremental, allowing you to change your approach—possibly backing off from changing conflicting areas.  

--

## Handling multiple changes in progress

+ Feature Toggles hide incomplete features in production
+ AKA Feature Shields/Flags/Switches/Flippers
+ Conditionals around bits of code/user interfaces
+ May be toggled on and off per environment
+ (see Further Reading for a good [Feature Toggles article](https://martinfowler.com/articles/feature-toggles.html))

--

## Trunk Development + CI == 👍

+ Changes to trunk always picked up by CI system
+ Feature changes are continuously integrated with each other
+ You *can* toggle features on per environment or per test
+ If you do, feature is tested on each push
+ Increased complexity—introduces a new code path
+ May need to run tests with multiple toggle combinations

Note: It is possible to do CI with branches but some organisations typical build process or CI tooling means they don’t.
  Testing features in isolation on branches is not CI.    
  Features promoted or new builds toggle per environment.  
  Feature branches don’t address complexity—can’t test integrated WIP.  

---

## Implementing a Feature Toggle

```javascript
  const features = fetchFeatureTogglesFromSomewhere();

  function generateInvoiceEmail(){
    const baseEmail = buildEmailForInvoice(this.invoice);
    if( features.isEnabled("next-gen-ecomm") ){ 
      return addOrderCancellationContentToEmail(baseEmail);
    }else{
      return baseEmail;
    }
  }
```

Taken from [Feature Toggles (aka Feature Flags)](https://martinfowler.com/articles/feature-toggles.html)

--

## Tidying Up

Code was added to implement feature toggles so we need to tidy this away once functionality fully released

---

## Exercise
### Make two changes using trunk based development

* Work in pairs - ___***sharing the same git repository***___
* Implement your own feature toggle
* One person implements Story 4 - After the first year
* One person implements Story 5 - Expensive vehicles after the first year
* Leave toggles off so that rules are not applied yet
  * Tests need to pass—turn the toggle on in your tests
* Turn the new features on one at a time

Notes:
See branch ```diesel_and_alternative_tax``` for a starting point to this exercise if they haven't completed the previous one.  
N.B. don't get them to checkout the branch (git weirdness will ensue), just get them to copy-paste the working code.  
There are already test suites for these stories they just need to be enabled so the build runs them.  
There is also an example solution on the ```subsequent_years``` branch.  

---

## A cautionary tale

[Knightmare: A DevOps Cautionary Tale](https://dougseven.com/2014/04/17/knightmare-a-devops-cautionary-tale/)

--

## Knight Capital (traders) had $365M in assets

--

## Deployment of new feature was incomplete

💻 ✅ 💻 ✅ 💻 ✅ 💻 ✅ 💻 ✅ 💻 ✅ 💻 ✅ 💻 ❌

Note:   
  One server (of eight) had not been updated by a human  
  Server running 8yr old code hidden by now reused toggle  

--

## New feature reused eight year old feature toggle

🤓 🤓 🤓 🤓 🤓 🤓 🤓 😡

Note:
  Single server had old behaviour activated instead  
  That server followed a different strategy

--

## 09:30 Market opens

<fragment/> (09:31 Market panics)

Note: Market saw problem in by 09:31—one minute after opening  
  No kill switch  

--

## Deployment backed out

(toggle left on)

😡 😡 😡 😡 😡 😡 😡 😡

Note:  
  Back out left resulted in eight bad servers—4 million transactions  

--

## $460 million loss over in 45 minutes

Bankrupt!

<img src=https://miro.medium.com/max/1240/1*-BDqsaWVHxONCnnJI3PetQ.jpeg>

<small><caption>[Source](https://medium.com/dataseries/the-rise-and-fall-of-knight-capital-buy-high-sell-low-rinse-and-repeat-ae17fae780f6) (origin unknown)</caption></small>

--

## Exercise: discuss what lessons should be learned (5 minutes)

* Split into small groups of about three
* Discuss what happened
* Note down 3–4 lessons that should be learned

--

## What should we learn?

+ Don’t reuse feature toggles
+ Delete redundant code
+ Humans make mistakes
+ Deployments should be automated, reliable and consistent
+ Risky changes should be easily deactivated

Note: Get them to call out what they wrote down  

---

## Deployment strategies

+ Blue Green
+ Canary
+ Ramped
+ Shadow
+ A/B Testing

--

## Blue green deployment

<img src=https://learning.oreilly.com/library/view/continuous-delivery-reliable/9780321670250/graphics/fig10_2.jpg>

+ Two long lived environments exist—‘blue’ and ‘green’
+ Traffic routed to ‘green’ environment
+ New version deployed to ‘blue’ environment
+ Traffic switched to ‘blue’ environment
+ ‘Blue’ is now production
+ Either deploy new version to ‘green’ and switch back or perform next deployment to green

<small>Image credit [Continuous Delivery, Humble & Farley](https://www.amazon.com/Continuous-Delivery-Deployment-Automation-Addison-Wesley-ebook/dp/B003YMNVC0)</small> 

--

## Blue green deployment pros/cons

+ 👍 Trivial to roll back (ignoring stateful apps)
+ 👍 Tests can be run against ‘blue’ environment before traffic switched
+ 👎 Uses twice the resources
+ 👎 Missed defects impact all users

Note: Point out that this can utilise existing redundancy.  

--

<backgroundimage>https://staticshare.america.gov/uploads/2014/11/canary_art22-1068x479.jpg</backgroundimage>
<backgroundimageopacity>0.25</backgroundimageopacity>

## Canary deployment

+ As in the canary in the coal mine
+ Feature released to small number of test users
+ Provides early warning sign
+ Released to 100% once confident
+ Sometimes called dark deployments
+ Similar to A/B Testing

<small>Image credit [State Department/Doug Thompson](https://share.america.gov/english-idiom-canary-coal-mine/)</small> 

Note: 
  You will always miss things and release defects/have issues in production.  
  Canary deployments are a technique to de-risk significant changes to production.  

--

<backgroundimage>https://staticshare.america.gov/uploads/2014/11/canary_art22-1068x479.jpg</backgroundimage>
<backgroundimageopacity>0.25</backgroundimageopacity>

## Canary deployment pros/cons

+ 👍 Visibility of problems before impacting everyone
+ 👍 Fast rollback
+ 👎 Takes longer to deploy
+ 👎 Can be hard to segment users
+ 👎 State can be hard to manage

--

## Ramped deployment

+ Naively replace/upgrade instances in serial
+ Traffic split across all instances
+ Possible to batch

--

## Ramped deployment pros/cons

+ 👍 Easy to set up
+ 👎 Slow
+ 👎 Risky to have multiple versions of the API / application available
+ 👎 Rollback is slow

--

## Shadow deployment

+ Version deployed without users being pointed at it
+ Realistic/duplicate traffic generated towards the new version
+ New version observed until confident
+ Traffic switched once confident

--

## Ramped deployment pros/cons

+ 👍 Real usage always beats scripted testing
+ 👎 Relies on manually monitoring or automating acceptance testing
+ 👎 Traffic might not be compatible with new version if the API has changed

--

## A/B Testing

+ Not really a form of deployment
+ Can be handled without changing deployment process
    + One version can present itself in different ways
+ Used to evaluate the impact of a change
+ Sometimes changes are prototypes
+ Users segmented and get different functionality based on their segment
+ Data gathered to inform decisions based on a statistically significant sample

--

## A/B Testing pros/cons

+ 👍 Real data to inform decisions
+ 👍 Can derisk significant changes
+ 👎 Can be hard to segment users—might require some investment

---

## Summary

* Continuous Integration: what/why/how
* Integrated our code with a free SaaS CI system
* Continuous Delivery: what/why/how
* Feature branching explanation and exercise
* Trunk based development explanation and exercise
* Other workflows are available

Notes:   
  Laptops closed.  

--

## Pros of Feature Branching

+ Once feature released, clean up as simple as deleting the branch
+ If feature abandoned, unused code not left polluting master
+ No need to deal with pesky conflicts while developing
+ Scales well with large number of features in progress

--

## Pros of Trunk Development

+ Changes visible to whole team throughout feature development
+ Code review regular rather than large and unpalatable
+ Feature can be tested on each push
+ Potentially earlier visibility of quality regressions
+ No big, scary merge at the end