# Search customers by loan amount range and status
This functionality will allows the system to search for customers based on load amount and loan status.
The restriction of just using customer and loan service is not clear. I am going to assume that the solution can add any needed API to customer or loan services.
 
## Solution one
This solution will use customer service and loan service to provide required search functionality. 
Sine loan service does not provide any API to find loans based on loan amount and loan status, then loan service will be changed to provide that API. 

### Solution details
Load service will provide a new API to search for loans based on loan amount and loan status. The API will call customers service and get customers by there id using retrieve customer API. 
Caching can be use to improve performance and save calls to customer service. 
That API will return a set of loans including loan customer information that satisfy the search criteria.
In the case no loans founded, the returned set will be empty.

### Solution disadvantage
This solution will add more load to the customers service and it will suffer from performance issues due to multiple calls to customer service. This issue can be solved by using caching.
The solution also couples loan service with customers service.

## Solution two
This solution is similar to solution one with the goal to improve performance and reduce coupling. 
To achieve that we need to create a new API for search functionality, and change create loanApplication API to get loan and customer information instead of just getting customer id.
Create loanApplication API will have customer table on its database which will be used to store customer information.

The search API will retrieve needed information from customer and loan tables and return a set of the search result.

### Solution disadvantage
- create loan application now have customer information which is an extra traffic. 
- duplication of data for customer information.
- Data inconsistency between customer information in customers service and loans service. This can happen if the customer information will changes in the customer service.
    

## Solution three
The following changes are needed:
- Loan service will provide an API to do search functionality. 
- A customer table on customer service will be replicated to loans service. replication will cover adding and updating customers.
- Weak relation ship between customer table and loans table will exist in the loans service. (no foreign key)

Search API will do a right outer join query on both loan and customer tables. This may result with loans without customer information due to some replication delay.

### Solution disadvantage
- duplication of data for customer information.
- search result may have loans without customer information.

