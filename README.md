# Week7WeekendCustomViewsAndViewGroups
This applications contains one Custom View, one Custom TextView, and one Custom ConstraintLayout. 

It demonstrates each in the MainActivity.

## Custom View: SeedOfLifeView
This Custom view has 5 attributes that can be set through the XML or programmatically. The attributes are: radius, color, xposition, yPosition, and lineWidth. It takes these attributes and draws the 19 circles that make up the Seed of Life, a geometric shape. The center is placed at the x and y positions, the radius of __each__ circle is determined by the radius, the color of the circles is determined by color, and the thickness of the lines that make up the circles are determined by lineWidth. If any of these 5 attributes are changed by a setter while the program is running, the view redraws itself to the new values.

## Custom TextView: ChangingTextView
This Custom TextView is made the exact same way a normal TextView is made, but it comes with its own OnClickListener and OnLongClickListener. If the TextView is clicked, then it cycles through a list of colors and changes. If the TextView is long clicked, then the style changes from: Normal, Bold, Italics, and Bolt Italics. The typeface is preserved when switching through these 4 styles. The default list of colors is: Black, Blue, Cyan, Green, Magenta, Red, Yellow, and the TextView's current color. The list of colors can be changed programmatically in the activity in which this view is declared through a setter.

## Custom ConstraintLayout: MediaPlayerView
This Custom ConstraintLayout or Compound View contains a Media Player object, one SeekBar, two TextViews and three Buttons.  The three buttons each have their own listeners that play, pause, and stop the media that is set using the Media Player object. Each button is disabled when its function is not relevant. The two TextViews only show values when a media is being played. The TextView on the left shows the current progress of the media, and the TextView on the right shows the time remaining. The Seek Bar is updated every 500 milliseconds while the media is playing to show the progress of the media, and the user can use the Seek Bar to select a specific part of the media to to skip to. The media created and managed by the Media Player must be set programmatically in the activity that contains the MediaPlayerView.

<img src="https://github.com/josecatalasan/Week7WeekendCustomViewsAndViewGroups/blob/master/screenshot1.png?raw=true" width="250"> <img src="https://github.com/josecatalasan/Week7WeekendCustomViewsAndViewGroups/blob/master/screenshot2.png?raw=true" width="250"> <img src="https://github.com/josecatalasan/Week7WeekendCustomViewsAndViewGroups/blob/master/screenshot3.png?raw=true" width="250">
