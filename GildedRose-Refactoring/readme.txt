======================================
Gilded Rose Requirements Specification
======================================

Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime location in a
prominent city ran by a friendly innkeeper named Allison. We also buy and sell only the finest goods.
Unfortunately, our goods are constantly degrading in quality as they approach their sell by date. We
have a system in place that updates our inventory for us. It was developed by a no-nonsense type named
Leeroy, who has moved on to new adventures. Your task is to add the new feature to our system so that
we can begin selling a new category of items. First an introduction to our system:

	- All items have a SellIn value which denotes the number of days we have to sell the item
	- All items have a Quality value which denotes how valuable the item is
	- At the end of each day our system lowers both values for every item

Pretty simple, right? Well this is where it gets interesting:

	- Once the sell by date has passed, Quality degrades twice as fast
	- The Quality of an item is never negative
	- "Aged Brie" actually increases in Quality the older it gets
	- The Quality of an item is never more than 50
	- "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
	- "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
	Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
	Quality drops to 0 after the concert

We have recently signed a supplier of conjured items. This requires an update to our system:

	- "Conjured" items degrade in Quality twice as fast as normal items

Feel free to make any changes to the UpdateQuality method and add any new code as long as everything
still works correctly. However, do not alter the Item class or Items property as those belong to the
goblin in the corner who will insta-rage and one-shot you as he doesn't believe in shared code
ownership (you can make the UpdateQuality method and Items property static if you like, we'll cover
for you).

Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a
legendary item and as such its Quality is 80 and it never alters.


mail content:



mark.emms@bt.com
Sep 29, 2023, 3:16 AM (3 days ago)
to me

Hi Jyotisree,

 

Thank you for applying for our role of Specialist Software Engineer. I am the hiring manager. After reviewing your CV we’d like to invite you to participate in a small coding exercise to get a better idea of your coding style and approach to problem solving.

 

It's a small refactoring exercise, you can find the repository here:

https://github.com/emilybache/GildedRose-Refactoring-Kata

 

Here are the requirements: https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/main/GildedRoseRequirements.txt

There are a number of software languages to choose from, please select your preference.

 

Here are some other points for guidance:

•             Part of what we look at when we evaluate your solution will be the git history, so good commit messages will help us to understand how you approached the exercise.

•             There is no "best" implementation, this is mostly a refactoring exercise - we're looking to see how you approach things rather than that you have come up with the most algorithmically-optimal solution.

When complete please ZIP your solution (password protected and remembering to include the git history) and attach it to an email by reply. Alternatively, you can share your GitHub project with me https://github.com/mark-emms

 

Please can you either email or share your solution on GitHub no later than end of day Monday 2nd October. If you need more time please contact me.

If you no longer wish to be considered for this role, please let me know so I can update our records.

Any questions feel free to reply to this email.

 

Regards,

Mark