<h1>Reddit Challenge - Intermediate #277 - Fake Coins</h1>

<h3>Description</h3>
<p>
Their are some false golden coins, which are lighter then others, in the treasure chest. 
The assistant has weighed the coins, but can not figure out which are false and which are not.<br/>
<br/>
Each coin is labelled with a letter, and is put on the scale in groups or by itself. 
The input consist of the coins on the left side, the coins on the right side and the way the scale tipped. 
This can be left, right or equal when the two sides weight the same.<br/>
<br/>
You must determine which coins are lighter then the others.
It is possible that you can't determine this because you have not in enough info.
And it is possible that the provided data has been inconsistent.<br/>
<br/>
You can assume that there is only 1 fake coin, if not, the data is inconsistent. 
If your solution worked without this assumption, you can leave it like that.
And all real coins weight the same, just like the fake coins. 
But no real weight is necessary to complete the challenge
</p>
 
<h3>Method</h3>
<p>
Each coin will have 3 possible marks. Normal, false & unsure.<br/>
If mean't to mark unsure 
 
1. If scales equal<br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	1.1 - If duplicate coin on either side<br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	1.1.1 - If SO mark duplicate as unsure. Mark other coins as normal.<br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 	1.1.2 - ELSE mark all normal.<br/>
2. If scales left<br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	1.1 - Mark all coins on left side as normal<br/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	1.2 - Mark all unmarked coins on right side as unsure. If only normal coins jump to 7.<br/>
3. If scales right<br/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	1.1 - Mark all coins on right side as normal<br/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	1.2 - Mark all unmarked coins on left side as unsure. If only normal coins jump to 7.<br/>
4. Repeat steps 1-3 for each line of user input<br/>
5. If only 1 coin is marked unsure than that coin is false<br/>
6. If no unsure than no fake coins detected<br/>
7. If multiple unsure than data is inconsistent/non-sufficient<br/> 
</p>
 
<h3>Links</h3>
<p>
Reddit - https://www.reddit.com/r/dailyprogrammer/comments/4utlaz/20160727_challenge_277_intermediate_fake_coins/
</p>
 
@author RMatos     <br/>
@version 1.0       <br/>
@since 25-01-2017  <br/>
