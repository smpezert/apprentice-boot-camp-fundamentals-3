## How to do Continuous Integration

--

## Important factors

+ Speed—short feedback loop
+ Reliability
+ Meaningful failures
+ Repeatability

--

## Good practices

+ Fix broken builds quickly (don’t commit over the top)
  + Be aware of failures—use notifications etc
+ Don’t ‘commit & quit’
+ You break it, you fix it
+ Fix or delete flaky tests (don’t just re-run)
+ Make sure your build stays fast
+ Keep test environment ‘like production’

Note: Some tests are unreliable—might fail 1% of the time.  
  Fast means 5 minutes or less for some positive feedback.  
  Test environment data is rarely comparible with production.  

---

## Typical Enterprise ‘Pipeline’

* Run fast tests
* Run slow tests and static analysis
* Publish packaged code
* Deploy to dev
* Deploy to test
* Deploy to production

---

## Many CI solutions

* Bamboo
* CircleCI
* CruiseControl.NET
* GitLab
* GoCD
* Jenkins
* TravisCI
* GitHub Actions

Note: Enterprises tend to favour on site code and CI buy moving towards cloud hosted solutions.   

--

## Common Features

+ GitHub Integration
+ Support for describing work-flows of parallel tasks
+ Ability to run against multiple versions / variants
+ Publishing / releasing built artifacts
+ SCM support: Git / Subversion / CVS / etc.
+ Language / build tool support
+ Notifications
+ Configuration as code

---

## Upcoming GitHub Actions CI exercise

+ Not expecting you to have used GitHub Actions
+ Using it today in an exercise as an example
+ Partly as it is easy to set up
+ We don’t use it other than this boot camp

--

## E.g. GitHub Actions CI

+ Add a YAML config file to your repository
+ Optional: add build badge to the repository

--

## Then…

+ Every time a commit is made
+ GitHub fetches that version of the code
+ GitHub works out what to run based on repository contents (including the YAML config)

--

## Build status

Status appears against each commit and PR.

<img src=images/github-actions-build-status.png>

--

## Configuring GitHub Actions

* Contents of a YAML file tell GitHub what to do
* Specific to each language…


---

## Caution: Git

<img src="https://imgs.xkcd.com/comics/git.png">

<small>[XKCD](https://xkcd.com/1597/)</small> 
