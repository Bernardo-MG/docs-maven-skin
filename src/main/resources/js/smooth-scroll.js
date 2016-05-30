/**
 * Licensed under the MIT License (http://www.opensource.org/licenses/mit-license.php)
 */
/**
 * Functions for smooth scrolling.
 *
 * This makes internal links to the same page scroll smoothly to the elements they are anchored to.
 *
 * To initialize the chevron toggle use the initSmoothScroll() function.
 */

/**
 * Initialize the smooth scroll feature.
 */
function initSmoothScroll() {
    $('a[href^="#"]').on('click', function (e) {
        // Prevents default anchor click behavior
        e.preventDefault();

        smoothScroll(this.hash);
    });
}

/**
 * Scrolls smoothly to the element with the specified hash.
 *
 * @param hash hash for the element where to scroll
 */
function smoothScroll(hash) {
    var offset = $(hash).offset();
    if (offset) {
        $('html, body').animate({
            scrollTop: $(hash).offset().top
        }, 300, function () {
            // After ending, the hash is added to the URL
            window.location.hash = hash;
        });
    }
}
