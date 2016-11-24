# Atlassian Quality Engineering Hiring - Technical Exercises

A recruitment exercise for Atlassian Quality Engineering

#### Contents

* [Introduction](#markdown-header-introduction)
* [Exercise 1 – Automation](#markdown-header-exercise-1-automation)
* [Exercise 2 – Exploratory Testing](#markdown-header-exercise-2-exploratory-testing)
* [Submitting the Exercises](#markdown-header-submitting-the-exercises)

#### Answer - Exercise 1 

* The script need clean-environment & setup-environment e.g.: setup database
* Just refactor framework and add some necessary checkpoints
* Cucumber is better but not implement
* `mvn clean install` to run all tests as parallel

#### Answer - Exercise 2

* Please refer to /Exercise2/Exercise 2.pdf


## Introduction

Quality Engineers at Atlassian are our (not so) secret weapon. They not only help teams continually improve the quality of the software they create, but they also help teams do it more efficiently. In short, our Quality Engineers are essential for shipping quality software faster.

Our developers know this. Our quality practices are regularly voted the most satisfying aspect of how we develop software at Atlassian. As such, developers constantly pull Quality Engineers into collaborating on their work. This is not a company where code is thrown over the wall to test, nor a place for people who don’t want to be deeply involved in the development process.

To be effective, our Quality Engineers need strong testing, technical and collaboration skills. The aim of these exercises is to allow you to demonstrate some of those.


## Exercise 1 – Automation

### Goal

Quality Engineers at Atlassian are often expected to assist their team with advice on all aspects of automation. The intention of this exercise is to demonstrate your automation coding ability and your understanding of what makes a great automated test.

### Scenario

Picture yourself working with a team of developers who create and maintain features in Confluence Cloud, Atlassian's hosted Wiki product. The team have decided to write some automated UI tests for their work and, using Selenium Webdriver, they have started writing a framework based on the  [PageObjects](https://github.com/SeleniumHQ/selenium/wiki/PageObjects) pattern. They have written tests to test new page creation and to test setting page restrictions.  

Whilst the developers have plenty of unit testing experience, they are inexperienced with UI testing and have asked for your help to show them where they can improve. They will use your changes as a reference for designing future tests.

### Requirements

* Apache [Maven](https://maven.apache.org/) version 3 – the framework uses Maven for running tests and managing dependencies
* Google [Chrome](https://www.google.com.au/chrome/) Browser – the tests are expecting to use this
* Atlassian [Confluence Cloud](https://www.atlassian.com/ondemand/signup/form?product=confluence.ondemand) – follow the link to sign up for a trial instance

### Getting Started

1. Make sure you've got all the requirements above
1. [Add a new user](https://confluence.atlassian.com/doc/add-users-and-set-permissions-349635148.html) to Confluence
1. [Fork](https://bitbucket.org/atlassian-qe/atlassian-qe-technical-exercises/fork) this repository
1. [Clone](https://confluence.atlassian.com/display/BITBUCKET/Clone+a+repository#Clonearepository-CloningaGitrepository) your new fork
1. On your local clone: 
	* Use your Confluence Cloud instance address to update the siteURL variable, found here: `src/test/java/com/webdriver/tests/TestBase.java`
	* Update the username & password variables in both test files to use the user you set up in Step 2
1. Run the tests using Maven: `mvn clean install`

It is up to you to determine what needs to done - add, modify or remove code wherever necessary to make these tests robust, maintainable and valuable.

To limit the time required for this exercise, don't worry about writing any new tests. If you want to provide any notes about the exercise, just leave them at the top of this readme.

You're now ready to start updating the code!

### Completing the Exercise

[Commit](https://confluence.atlassian.com/display/BITBUCKET/Work+on+local+source+files#Workonlocalsourcefiles-WorkingonfilesinGit) your changes and [push](https://confluence.atlassian.com/display/BITBUCKET/Push+updates+to+a+repo) them back up to your Bitbucket repository. When you're done with both exercises, send them to us by completing the steps shown in the [Submitting The Exercises](#submit) section below.


## Exercise 2 – Exploratory Testing

### Goal

Coaching developers in testing skills is a regular part of the job for Atlassian's Quality Engineers. We teach our developers Exploratory Testing to help them to think critically and uncover high impact risks in their own work. The intention of this exercise is to allow you to demonstrate your ability to identify valid risks in a feature, without using specifications or scripted test cases.

### Scenario

A new developer in your team has just completed a feature in Confluence called _Reorder Pages_. It displays all the pages that belong to a specific space in an expandable tree and allows the user to rearrange the page order and hierarchy. 

The developer has already tested that basic happy-path sorting and drag & drop scenarios are working, but they are not sure what other risks they should be looking for and have asked for your help.

![The Reorder Pages feature](images/exercise2-example_page_tree.png)

### Getting Started

* You can use the same Confluence Cloud instance that you created for the previous exercise
* The _Reorder Pages_ feature can be accessed by clicking “View in Hierarchy” from the “...” menu in the top-right corner when viewing a Confluence page.

![How To Access The Reorder Pages Feature](images/exercise2-how_to_access.png)

### Completing the Exercise

The scope of the exercise is limited to the _Reorder Pages_ tab. You should not test the other tabs (Orphaned Pages, Undefined Pages, etc.) or other Confluence features, except where they help you assess risks related directly to this feature.

1. Before starting, read the _Recording Your Results_ section below
1. Perform an initial 30 minute round of exploratory testing
	* Aim to go beyond basic happy-path functional testing - consider other areas of risk
1. Once you are familiar with the feature, think about what other areas/risks need to be explored and determine what further testing the feature may need before you would consider it ready to be released to production

### Recording Your Results

Create a file (Text, PDF, Word or Markdown) containing:

* A short description (1-2 sentences) of the approach you took to your testing.
* A bulleted list of the scenarios you tried, even if they were successful. For example:
	* “Tried to drag a parent page to become a grandchild of itself”
	* “Tried to use the web service to make a page a child of itself”
* A quick description of any bugs you found. It’s OK to not have found any – we’re more interested in your test ideas and approach
* Your list of further testing areas that you would want completed before you would be comfortable shipping this feature to millions of users.

We're more interested in your approach to identifying risk than we are in the total number of bugs found, so whilst you can choose to continue exploratory testing beyond 30 minutes, we generally find the value in doing so is limited.

Once completed, please push the file to your Bitbucket repository that was set up during Exercise 1.


## Submitting The Exercises

After you've pushed both exercises to your private Bitbucket repository, follow these steps to share your submission with Atlassian:

1. In your Bitbucket repository, under `Settings > User and Group access` add the user `atlassian-qe` and grant Admin privileges
1. Let us know the link to your repository via email
