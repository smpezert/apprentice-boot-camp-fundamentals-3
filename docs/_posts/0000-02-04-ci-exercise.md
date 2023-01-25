## Exercise prep

If you haven’t got set up yet, see the [preparation instructions in the README](/README.md#prep-work-for-apprentices).

Note: explain difference between forking and using a template.  
  Share the exercise slide!  

--

## Exercise Part 1: Set up GitHub Actions

* Look at your fork of the repo at https://github.com
* Select the 'Actions' tab
* Click the 'New workflow' button
* Find the right workflow for your language (ask if you're not sure)
* Click the 'Configure' button
* You should see an online editor with a default YAML file loaded

Note:
  Share the exercise slide!  

--

## Exercise Part 2: Configure your build

* The only configuration you should need to change is your build's working directory
* Hopefully see your tests pass

--

Java / Kotlin
```yaml
- name: Build with Gradle
  uses: gradle/gradle-build-action@67421db6bd0bf253fb4bd25b31ebb98943c375e1
  with:
    arguments: build
    build-root-directory: exercises/java
```

--

C#
```yaml
defaults:
  run:
    working-directory: exercises/dotnet

jobs:
  ...
```

--

PHP
```yaml
defaults:
  run:
    working-directory: exercises/php
    
jobs:
  ...
  - name: Run test suite
    run: ./vendor/bin/phpunit --testdox tests
```

--

Javascript / Typescript
```yaml
defaults:
  run:
    working-directory: exercises/typescript

jobs:
  ...
    steps:
      - uses: actions/checkout@v3
      - name: Use Node.js ${{ matrix.node-version }}
        uses: actions/setup-node@v3
        with:
          node-version: ${{ matrix.node-version }}
          cache: 'npm'
          cache-dependency-path: 'exercises/typescript/package-lock.json'
```

--

## Exercise Part 3: Make it fail

* Pull down the changes (the YAML config) you just made on GitHub
* Find the tests which aren't running (the ones for petrol vehicles)
* Make the tests run (and fail)
* Push your change
* Watch it fail

Note: Need to pull before you can push.  

--

## How does vehicle excise duty (vehicle tax) work?

+ How much tax you pay depends on a few things
+ In the first year it depends on the CO2 emissions and the fuel type
+ After the first year a ‘standard’ yearly rate applies depending on:
  + the fuel type 
  + the value (if it’s over £40,000)
+ There’s a detailed explanation on the [Auto Trader website](https://www.autotrader.co.uk/content/advice/car-tax-bands)

--

## Exercise Part 4: Make it pass

* Implement code to make **_only the petrol tests_** pass (see [Story 1](https://github.com/MCR-Digital/apprentice-boot-camp-fundamentals-3/tree/master/exercises#story-1))
* ___***Do not change ‘DummyTaxCalculator’***___—write your own implementation (e.g. ‘DefaultTaxCalculator’)*
* Try to ___***keep your build green***___
* ___***Do not change the tests***___ (except to introduce your new calculator)
* Push your change and watch the build pass

**\*N.B. you'll need to set the year to `2019` in your `TaxCalculator` object**

Note: Did you get an email telling you it had failed?  
  Share the exercise slide!  

--

## Exercise Reflection

+ What do you think you actually set up?
+ How easy was it to set up?
+ How many commits did you make?
+ How does this contrast with your organisation?
