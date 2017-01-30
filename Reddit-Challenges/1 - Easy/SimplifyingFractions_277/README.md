<h1>Reddit Challenge - Easy #277 - Simplifying Fractions</h1>

<h3>Description</h3>
<p>
A fraction exists of a numerator (top part) and a denominator (bottom part) as you probably all know.
Simplifying (or reducing) fractions means to make the fraction as simple as possible. 
Meaning that the denominator is a close to 1 as possible. 
This can be done by dividing the numerator and denominator by their greatest common divisor.
</p>

<h3>Method</h3>
<p>
1. Check to see if numerator and denominator are the same number, making the simplified 'fraction' 1.<br/>  
2. Determine which number is smallest; denominator or numerator.<br/> 
3. Check to see if smallest number is in fact the HCF. Jump to 5.<br/> 
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	3.1 - If SO then HCF has been found.<br/> 
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	3.2 - If NOT smallest number is / 2 and used as start for determining HCF.<br/> 
4. That number is then checked for whether it is fully divisible by numerator and denominator <br/> 
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	4.1 - If SO then HCF has been found. Jump to 5.<br/> 
  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	4.2 - If NOT decrement number and retry step 4.<br/> 
   	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	4.3 - If number is 0 there is no HCF.<br/> 
5. Output Result. If HCF is found. <br/> 
   	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	5.1 - If SO output simplified fraction & HCF<br/> 
   	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	5.2 - If NOT output that no HCF is found and therefore fraction can't be simplified<br/> 
</p>

<h3>Links</h3>
<p>
Reddit - https://www.reddit.com/r/dailyprogrammer/comments/4uhqdb/20160725_challenge_277_easy_simplifying_fractions/
</p>

@author RMatos    <br/> 
@version 1.0      <br/> 
@since 24-01-2017 <br/> 
