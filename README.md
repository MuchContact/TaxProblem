TaxProblem
==========
***
 Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.

When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid.  The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

Write an application that prints out the receipt details for these shopping baskets...
***
### INPUT:

*Input 1*:
>1 book at 12.49  
>1 music CD at 14.99  
>1 chocolate bar at 0.85  

*Input 2*:
>1 imported box of chocolates at 10.00  
>1 imported bottle of perfume at 47.50  

*Input 3*:
>1 imported bottle of perfume at 27.99  
>1 bottle of perfume at 18.99  
>1 packet of headache pills at 9.75  
>1 box of imported chocolates at 11.25  

### OUTPUT

*Output 1*:
>1 book : 12.49  
>1 music CD: 16.49  
>1 chocolate bar: 0.85  
>Sales Taxes: 1.50  
>Total: 29.83  

*Output 2*:
>1 imported box of chocolates: 10.50  
>1 imported bottle of perfume: 54.65  
>Sales Taxes: 7.65  
>Total: 65.15  

*Output 3*:
>1 imported bottle of perfume: 32.19  
>1 bottle of perfume: 20.89  
>1 packet of headache pills: 9.75  
>1 imported box of chocolates: 11.85  
>Sales Taxes: 6.70  
>Total: 74.68  
  
***
### Changeable Parts Designed
- `Parser` - where the input is parsed into a bean which is used by `Cart` as a middle data structure.
- - `RegItemParser` - provides an specific implementation using Regular Expression.
- `TaxCalculable` - defines the essential Calculator interfaces to implement.
- -`TaxCalculator` - this is an specific implementation of `TaxCalculable`
- `Roundup` - defines roundup interface.
- - `RoundupToNearestFivePercentImpl` - this is an implementation of `Roundup`, round up number to the upper nearest 0.05
- `Purchasable` - an abstract interface for all things purchasable, `Cart` can manage a list of specific purchasable objects, like `Item` `Good`.
***
### Tests
- rounding
	- rules for numbers which is not consisted of n 0.05 exactly
		- examples: rounding up to 0.15 given 0.13
		- examples: rounding up to 0.20 given 0.16
		- examples: rounding up to 0.20 given 0.151
	- rules for numbers which is consisted of n 0.05
		- examples: rounding up to 0.15 given 0.15
		……
- tax rate
	- get 10% given normal (unimported and unexempted) good types
	- get 0% given unimported and exempted good types
	- get 15% given imported and unexempted good types
	- get 5% given imported and exempted good types
- tax
	- rules for unimported and unexempted goods
		- examples: charge 20.89 given (1 bottle of perfume) 18.99
		- examples: charge 16.49 given (1 music CD) 14.99
	- rules for imported and unexempted goods
		- examples: charge 32.19 given (1 imported bottle of perfume) 27.99 
	- rules for unimported and exempted goods
		- examples: charge 12.49 given (one book) 12.49
		- examples: charge 0.85 given (1 chocolate bar) 0.85
	- rules for imported and exempted goods
		- examples: charge 11.85 given (1 box of imported chocolates) 11.25 
- Parser
	- rules for parsing name
		- examples: get "book" given "1 book at 12.49"
		- examples: get "headache pills" given "1 packet of headache pills at 9.75"
		...
	- rules for parsing unit
		- examples: get "bottle" given "1 bottle of perfume at 18.99"
		- examples: get "" given "1 chocolate bar at 0.85"
		...
	- rules for parsing price
	- rules for parsing quantity
	- rules for parsing imported
	- rules for parsing exempted
