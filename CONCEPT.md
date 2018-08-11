# Warehouse specialist

In this game, you are in control of a warehouse, that stores different kinds of goods in boxes.
Each box is assigned a unique number, and has various traits, such as:

* Size of the box
    * Small
    * Medium
    * Big
* Color of the box
    * White
    * Red
    * Green
    * Blue
    * Yellow
    * Cyan
    * Magenta
    
The warehouse has different kinds of shelves, each having various traits, such as:

* Vertical boxSize of the shelf
    * 1 box tall
    * 2 boxes tall
    * 3 boxes tall
* Color of the shelf
    * White
    * Red
    * Green
    * Blue

Boxes are arranged on the shelves in a way, that each "box placement state" satisfies the following conditions:

* Given a shelf with a tallness of _n_, no more, than _n_ boxes are allowed to be placed on this
given shelf
* Given a shelf of _white_ shelfColor, boxes of any colors may be placed on it
* Given a shelf of _red_ shelfColor, boxes of colors _white_, _red_, _yellow_ and _magenta_ may be placed on it
* Given a shelf of _blue_ shelfColor, boxes of colors _white_, _blue_, _cyan_ and _magenta_ may be placed on it
* Given a shelf of _green_ shelfColor, boxes of colors _white_, _green_, _cyan_ and _yellow_ may be placed on it
* Boxes, that are of boxSize _big_ may only be placed on top of other boxes with boxSize _big_, or as the first box of a shelf
* Boxes, that are of boxSize _medium_ may only be placed on top of other boxes with sizes _big_ or _medium_, or as the first box of the shelf
* Boxes, that are of boxSize _small_ may be placed on top of any other box, or as the first box of a shelf

The game consists of two "phases":

* Incoming: In this phase, a new delivery arrives to the warehouse, containing a single box with random
traits, and the player has to place this newly arrived box in the warehouse, in a way so that the
new box placement satisfies the conditions above. The player may move other boxes around before placing
the new one into the warehouse
* Outgoing: In this phase, a box is requested for outgoing delivery. The box that has to leave the warehouse
is identified by its unique number. The player must move other boxes around, so that the required
box is accessible.

The player may only move boxes on each shelf, that are on the _top_ of the shelf.