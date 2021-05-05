## Exercise prep

(in case you haven’t got set up yet)

* Fork https://github.com/MCR-Digital/tax_calculator
* `git clone https://github.com/[USER]/tax_calculator.git`
* Make sure you can run tests in your language  
(they are all ignored to start with)
  * Java folk: open IntelliJ IDEA and from the `File` menu choose `Open`, then select the `build.gradle` file from the `exercises\java` directory.

--

## Exercise Part 1: Set up Travis CI

* Work in pairs
* Fork the example repository https://github.com/MCR-Digital/tax_calculator.git
* Log into https://travis-ci.org
* Check that you can see your repository in the list
* Activate Travis CI for your fork

Note: Make sure you have the right Travis CI  
  travis-ci.com is the paid for enterprise version  

--

## Exercise Part 2: Configure your build

* On GitHub, create `.travis.yml` at root of repo
* Hopefully see your tests pass


```yaml
language: java
before_script: "cd exercises/java"
```
<!-- .element: style="font-size: 35%" -->

```yaml
language: csharp
solution: exercises/dotnet/TaxCalculator.sln
before_script: "cd exercises/dotnet"
mono: none
dotnet: "2.1.502"
script: 
  - "dotnet restore"
  - "dotnet test"
```
<!-- .element: style="font-size: 35%" -->

```yaml
language: node_js
before_install: "cd exercises/javascript"
node_js:
  - 10
```
<!-- .element: style="font-size: 35%" -->

```yaml
language: python
before_script: "cd exercises/python"
python: 
  - "3.6"
script: 
  - pytest
```
<!-- .element: style="font-size: 35%" -->

Note: Remind them about the dot at the front of the filename!  

--

## Exercise Part 3: Make it fail

* Find the tests which aren't running (the ones for petrol vehicles)  
* Make the tests run (and fail)  
* Push your change  
* Watch it fail  

--

## Exercise Part 4: Make it pass

* Implement code to make the tests pass (see Story 1)
* ___***Do not change ‘DummyTaxCalculator’***___—write your own implementation (e.g. ‘DefaultTaxCalculator’)*
* Try to ___***keep your build green***___
* ___***Do not change the tests***___ (except to introduce your new calculator)
* Push your change
* Watch it pass

**\*N.B. you'll need to set the year to `2019` in your `TaxCalculator` object**

Note: Did you get an email telling you it had failed?  

--

## Exercise Reflection

+ What do you think you actually set up?
+ How easy was it to set up?
+ How many commits did you make?
+ How does this contrast with your organisation?
