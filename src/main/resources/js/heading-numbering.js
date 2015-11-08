/**
 * Licensed under the MIT License (http://www.opensource.org/licenses/mit-license.php)
 */
/**
 * Functions for numbering headings.
 *
 * Only headings of level 2 and 3 will be numbered. Said numbering works in a consecutive way, like this:
 *
 * Level 1 heading
 * 1 Level 2 heading
 * 1.1 Level 3 heading
 * 2 Level 2 heading
 * 2.1 Level 3 heading
 * 2.2 Level 3 heading
 *
 * JQuery is used for this, and so is a required dependency.
 *
 * Also, the headings order is expected to be respected, and no heading level should be skipped, for example by
 * adding a level 3 heading after a level 1 heading.
 *
 * Loading this file will automatically initialize the scripts. This way the headings are numbered just by adding it.
 */

var indices = [];

/**
 * Initializes the heading numbering.
 */
$(document).ready(function () {

    headingNumbering();

});

/**
 * Gives a number to the headings of level 2 and 3.
 *
 * This will be done in a consecutive way, and showing the heading depth, like this:
 *
 * Level 1 heading
 * 1 Level 2 heading
 * 1.1 Level 3 heading
 * 2 Level 2 heading
 * 2.1 Level 3 heading
 * 2.2 Level 3 heading
 */
function headingNumbering() {

    jQuery('h2,h3').each(function (i, e) {
        var hIndex;

        hIndex = parseInt(this.nodeName.substring(1)) - 2;

        // Getting deeper into the heading hierarchy
        if (indices.length - 1 > hIndex) {
            indices = indices.slice(0, hIndex + 1);
        }

        // Getting out of the heading hierarchy
        if (indices[hIndex] === undefined) {
            indices[hIndex] = 0;
        }

        // Increases the count for the current heading
        indices[hIndex]++;

        // Displays the heading numbering
        jQuery(this).prepend(indices.join(".") + ". ");
    });

}