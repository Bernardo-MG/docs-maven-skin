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
 */

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
function numberHeadings() {
    var indices = [];
    var firstHeading = 2;

    jQuery('h2,h3').each(function () {
        var hIndex;

        // Prepares the index for this heading
        hIndex = parseInt(this.nodeName.substring(1)) - firstHeading;

        // Initializes heading index
        if (indices.length <= hIndex) {
            // There are gaps in the numbering array
            for (var i = indices.length; i <= hIndex; i++) {
                indices[i] = 0;
            }
        } else if (indices.length > (hIndex + 1)) {
            // Lower indices are removed
            indices.splice(hIndex + 1, indices.length);
        }

        // Increases the count for the current heading
        indices[hIndex]++;

        // Displays the heading numbering
        var numbering = indices.join(".") + ". ";
        jQuery(this).prepend(numbering);
    });

}