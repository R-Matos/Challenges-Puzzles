<h1>ICPC - Asteroid Problem</h1>

<h3>Description</h3>
<p>
Full problem description can be found in <a href="https://github.com/RMatos2442/Challenges-Puzzles/blob/master/International-Collegiate-Programming-Contest/Asteroid/Asteroids_Problem_Sheet.pdf">this</a> pdf. 
<br><br>
<b>TLDR:</b>
<br>
There are two polygons with a constant acceleration heading to intersect. 
<br>
Determine at what time they overlap the most.
</p>

<h3> Method </h3>
At each second:
<ol type="1">
  <li>Translate polygons to new coordinates                     [IMPLEMENTED]</li>
  <li>If polygons overlap (naive collision detection)           [IMPLEMENTED]
    <ol type="1">
    <li>Determine intersecting vertices between polygons        [IMPLEMENTED]</li>
    <li>Join vertices to form triangles</li>                    [NOT IMPLEMENTED]
    <li>Add areas of each triangle for overlapping area</li>    [NOT IMPLEMENTED]
    <li>If area > than any previously save time</li>            [NOT IMPLEMENTED]
  </li>
</ol>


<h3> Resources Used </h3> 
 
<ul>
  <li>https://icpc.baylor.edu/worldfinals/problems/icpc2015.pdf</li>
  <li>http://ucsmp.uchicago.edu/secondary/curriculum/advanced-algebra/demos/polyplotter-aa/</li>
  <li>http://www.webmath.com/equline1.html</li>
  <li>http://www.mathcelebrity.com/parperp.php</li>
</ul>


@author  RMatos     <br/> 
@version 1.0        <br/> 
@since   26-07-2017 <br/> 
