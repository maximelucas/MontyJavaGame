Monty Java and the Holy Grail
=============

This is a 2D game project for an OOP class in Java, using the MVC design pattern.  
It was written for a course project.

## Story
You are a part of King Arthur’s Round Table and have one goal in life: find the
Holy Grail. For this, you will have to find it but more important, to be brave
enough to earn it ! During your quest, you will come accross people willing to help
you and others to stop you. One more thing ! You do not have much time, the
police is looking after you. Indeed, you killed that historian, remember ...?

## How to play
#### Choose difficulty 
The player plays alone with a knight (represented by the letter
"p" for player) whose two main skills are fighting and joking. When the game
is launched, the player is asked to choose a difficulty level. The difficulty level
influences the total of fighting and joking skill points the player begins with: more
difficult, less skilled.  
#### Goal 
The player finds himself on a map, represented by tiles, and can move using
the arrow keys, one tile by one. The player can only see two tiles far around him,
the rest hidden. The goal is to reach the tile where the Holy Grail (represented by
a "t" for trophy) is, and to be skilled enough (at least 15 fighting or joking skill
15 points) to earn it and win. Beware: the player has a finite number of steps to do,
or lose. Each time he walks on grass, he loses a step, but not when he walks on
the road.

#### Rules 
How to improve the player’s skills ? The player may encounter minstrels
that will help him (represented by a "h" for helper). When so, the player is asked if
he wants improve his fighting or joking skills, or gain some extra steps. The player
may also encounter enemies ("e"), which he will have to beat in a fight, or make
laugh enough with a joke. The skills points needed to beat the enemy, depends on
each of them and is random. If the enemy is beaten, the player will gain some skill
points according to the chosen type of "combat": joke or fight.  
#### Score 
Every time the player beats an enemy, the score is increased. Hence, even
if the player loses the game (ie does not win the trophy), the high score can be
beaten. Winning the Holy Grail obviously makes it easier to do so, since it increases
the score by much.
