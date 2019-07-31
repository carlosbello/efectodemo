# Examples of history manipulation

## See it working ##

To see this examples *properly working* open [this link](http://carlosbello.github.io/efectodemo/navigation-history/index.html) using a desktop browser or any mobile browser different from Chrome.

If you want to se it *sadly failing* open [this link](http://carlosbello.github.io/efectodemo/navigation-history/index.html) using Chrome from any Android device and read the [Final notes](#final-notes) to know why it will fail on Android and what to do.

[Open the expamples of history manipulation](http://carlosbello.github.io/efectodemo/navigation-history/index.html)

## Read the source ##

[Natural history behavior](back.html)
When the back navigation button is pressed, the browser renders the navigation demo page.

[Back override to a different page in the same domain](back-override-same-domain-with-gesture.html)
When the back navigation button is pressed, the browser redirects to a different page *in the current* domain

[Back override to a different domain](back-override-different-domain.html)
When the back navigation button is pressed, the browser redirects to a different page *in a different* domain

## Final notes ##

**Important!** These hacks won't work on Chrome so, try to avoid using these strategies. For more info about how and why it won't work see:
* [Google Chrome To Stop Sites From Messing with the Back Button](https://www.bleepingcomputer.com/news/security/google-chrome-to-stop-sites-from-messing-with-the-back-button/)
* [Fix on the way for Google Chrome flaw allowing malicious websites to break back button](https://www.techrepublic.com/article/fix-on-the-way-for-google-chrome-flaw-allowing-malicious-websites-to-break-back-button/)

**So.. What can I do to override the navigation history?**
Every time you want to override a page in a sequence, navigate or redirect using the JavaScript `document.location.replace` method.