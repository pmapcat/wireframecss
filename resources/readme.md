# A set of practical framework agnostic CSS classes with zero configuration


## Cut padding and margin of element

`{{prefix}}-cut`
And also:  `{{prefix}}-cut-**top**` `{{prefix}}-cut-**right**` `{{prefix}}-cut-**left**` `{{prefix}}-cut-**bottom**`

Useful when you want to put elements near to each other. 

### Example

<div>
  <h3 class="{{prefix}}-cut-bottom">A title<h3>
  <p class="{{prefix}}-cut-top">This is a description block of the given title</p>
  <hr>
</div>


## Float element

`{{prefix}}-float-left` or `{{prefix}}-float-right`

Will float the element either on the *left*, or on the *right*. It is equivalent of:

```css
{{prefix}}-right {
  float:right;
}

{{prefix}}-left {
  float:left;
}
```

## Align (or flush) layout either (left,right,center or justify)

* `{{prefix}}-flush-left`
* `{{prefix}}-flush-right`
* `{{prefix}}-flush-center`
* `{{prefix}}-flush-justify`

Which is equivalent to:

```css
{{prefix}}-flush-left {
  text-align:left;
}
```

## Pad and margin by amount

Will pad the element either on **top** **bottom** **right** or **left** or in **all directions**
Padded amounts are layed out in `em` and according to **ratio**:
`{{ratio}}`

### Example
<div>
  <div class="{{prefix}}-pad colored">{{prefix}}-pad</div>
  <div class="{{prefix}}-pad-top-1  colored">{{prefix}}-pad-top-1</div>
  <div class="{{prefix}}-pad-bottom colored">{{prefix}}-pad-bottom</div>
  <div class="{{prefix}}-pad-left colored">{{prefix}}-pad-left</div>
  <div class="{{prefix}}-pad-right colored">{{prefix}}-pad-right</div>
</div>

### Here are all possible layouts:
* `{{prefix}}-pad-top`
  * `{{prefix}}-pad-top-1`
  * `{{prefix}}-pad-top-2`
  * `{{prefix}}-pad-top-3`
  * e.t.c.
* `{{prefix}}-pad-botttom`
  * `{{prefix}}-pad-bottom-1`
  * e.t.c
* `{{prefix}}-pad-left`
  * `{{prefix}}-pad-left-1`
  * e.t.c
* `{{prefix}}-pad-right`
  * `{{prefix}}-pad-right-1`
  * e.t.c
  
### And the same true for **margin**:

* `{{prefix}}-margin-top`
  * `{{prefix}}-margin-top-1`
  * `{{prefix}}-margin-top-2`
  * `{{prefix}}-margin-top-3`
  * e.t.c.
* `{{prefix}}-margin-botttom`
  * `{{prefix}}-margin-bottom-1`
  * e.t.c
* `{{prefix}}-margin-left`
  * `{{prefix}}-margin-left-1`
  * e.t.c
* `{{prefix}}-margin-right`
  * `{{prefix}}-pad-right-1`
  * e.t.c

## Font size 

`{{prefix}}-fs` 
And also: `{{prefix}}-fs-0`  `{{prefix}}-fs-1`  `{{prefix}}-fs-2`  `{{prefix}}-fs-3`  e.t.c.

### Sample
<div>
  <div class=
<div>




