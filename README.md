# Wireframe CSS

<img src="https://raw.githubusercontent.com/MichaelLeachim/wireframecss/master/resources/public/screenshot.png" style="text-align:center;"></img>


**Documentation** and compilled styles are available [here](https://wireframecss.michaelleahcim.com/)

## Minified CSS

Colors take up the most space. The library with color will take **7.6K** gzipped
And without color it will only take **1.6K** gzipped

* [Prefix **qq** without palette](https://wireframecss.michaelleahcim.com/qq/f/wireframe.css)
* [Prefix **qq** with    palette](https://wireframecss.michaelleahcim.com/qq/t/wireframe.css)
* [Prefix **dd** without palette](https://wireframecss.michaelleahcim.com/dd/f/wireframe.css)
* [Prefix **dd** with    palette](https://wireframecss.michaelleahcim.com/dd/t/wireframe.css)

## The reasons behind the implementation

These are the classes that I find useful most of the time when working 
with CSS. Although, some of the frameworks have similar 
helpers, not all of them have all those that I need. 
And they tend to name things differently there.

## Tips

Use **-angry** suffix to override your framework defaults (add **!important** ) to the selected rules
For example: **.qq-cut-bottom becomes** turns into **.qq-cut-bottom-angry**

## Showcase (mostly my stuff here)

* [Static blog engine. Building theme in conjunction with PureCSS](https://www.michaelleahcim.com/blog/all/0/index.html)
* [(HTML screens in conjunction with PureCSS)](https://www.michaelleahcim.com/work-article/group_tracker.html)
* [(HTML screens in conjunction with PureCSS)](https://www.michaelleahcim.com/work-article/log_tagger.html)
* [(HTML screens in conjunction with PureCSS)](https://www.michaelleahcim.com/work-article/filecat.html)
* [(HTML screens in conjunction with SemanticUI)](https://www.michaelleahcim.com/work-article/clipper.html)


## Running and customization

You will need [Leiningen][] 2.0.0 or above installed.
You will also need [Tmuxinator][] 

[leiningen]:  https://github.com/technomancy/leiningen
[tmuxinator]: https://github.com/tmuxinator/tmuxinator

Then 
```
git clone github.com/MichaelLeachim/wireframecss; 
cd wireframecss;
tmuxinator .
```

Several things to play with in `conf.clj`:

* Scaling units, default are `[0.5em, 1em, 1.5em, 2.5em, 4em, 6.5em, 10.5em]`
* Amount of available drills, defaults are `6`

## TODO

* Make **explode/expand** blocks that defy their container constraints through the use of negative margins. 
  * Figure out how to make it work nicely on mobile
* Make `:hover` accents for colors and backgrounds
* Implement color engine:
  * *complementary*/*adjacent*
  * *adjacent* colors
  * *grayscale* 
* Make online configuring tool 

