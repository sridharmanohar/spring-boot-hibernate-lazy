# Lazy Loading in Hibernate with Spring Boot (and avoiding MultipleBagFetchException)

## Scenario: 
Company entity has two Collections (in the form of Lists), one each for Product and Employee.  
a. If I make the FetchType for both collections as EAGER, hibernate throws MultipleBagFetchException.  
b. If I make both of them LAZY, when I am trying to access the LAZY collection, hibernate throws LazyInitializationException, saying could not initializeproxy - no session.  

## Solutions:
1. Make one of the collections in the Company class into a Set. This will avoid the MultipleBagFetchException and you can carry on with both having FetchType as EAGER.
2. If you want them as Lists only, then make at-least one of the collections to have a FetchType of LAZY (to avoid MultipleBagFetchException) and annotate the method which is trying to access the lazy collection with a @Transactional (either w/ javax.persistence annot. or w/ spring annot.) to avoid LazyInitilizationException. 

## Performance Observations:
1. Did this with 10 companies and 10 employees for each company (did not involve product in this).
2. Whether it's LAZY or EAGER, hibernate executes the same no.of queries, 1 to fetch all companies and 1 query each to fetch all employees of a company. 
3. But the point-of-time when the employees are fetched varies w/ LAZY and EAGER. In EAGER, all these are run even before any access is made for Employee whereas in case of LAZY, the Employee related queries are run only when we try to access the Employee. 
4. And hence this is the major difference. If you are only going to access (in the current transaction/resultset) Company and not Employee and if you still use EAGER then average operation time is 225 ms whereas If you use LAZY then average operation time is 105 ms. This is a huge difference.
5. But, if you are going to access both Company and Employee in the same call then whether you use EAGER or LAZY does not matter much in terms of operational time. Avg. w/ LAZY is 228 ms and w/ EAGER is 215 ms.   