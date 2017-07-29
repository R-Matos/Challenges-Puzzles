<h1>Don't Get Rooked</h1>
<p>Challenge from ACM ICPC Mid-Central USA 1998.</p>

<h3>TLDR Description</h3>
<p>
Dots can see vertically and horizontally but not diagonally. <br>
Dots can't see over walls. <br>
Find out the maximum number of possible dots on the board without them seeing each other. 
</p>
 
<h3>Method</h3>
<p>
 	<ol type ="1">
 		<li>Places dots around walls (horizontally and vertically, not diagonally)</li>
		<li>Remove any conflicts (dots see each other)</li>
		<li>Add additional dots on board where no conflicts arise</li>
		<li>Count number of dots present, this is the maximum possible number</li>
	<ol>
</p>
		
<br>

<p>
@since 29-07-2017 <br>
@version 1.0 <br>
@author RMatos <br>
@see 
	<br>
<a href="http://acm.hit.edu.cn/hoj/problem/view?id=1086">Challenge Description Website</a>
	<br>
<a href="https://github.com/RMatos2442/Challenges-Puzzles/blob/master/International-Collegiate-Programming-Contest/Dont_Get_Rooked/Problem_description.pdf">Challenge Description pdf</a>
</p>
