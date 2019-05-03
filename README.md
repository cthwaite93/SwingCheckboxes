# SwingCheckboxes

This little Java repo is an introduction to the SWING library to work with Java's AWT. In this app we lay the bases of the n-ary tree structure of the main containers and its childs, layouts, fonts and a simple listener.

## Design
The way the app is laid out is through the following structure:

**JFrame** *(BorderLayout)* ->  
  *{Center}*: **JPanel** *(BorderLayout)* -> *{Center}*JLabel  
  *{West}*: **JPanel** *(GridLayout{4, 1})* ->  
    [4x] JCheckBox  

## Function
When we check one of the checkboxes it applies the style to the font and label. If we uncheck the style returns to the default behaviour. We can apply more than one style on the label.

### Disclaimer
The way that this app is programmed is not the way that you must program it. It is the simplest way I've found to relay the knowledge of the basics of SWING to make it understandable.

## You are free to download and use this code freely for any use.
