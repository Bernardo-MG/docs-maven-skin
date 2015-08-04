/**
 * Functions for smooth scrolling.
 *
 * This makes internal links to the same page scroll smoothly to their anchors.
 *
 * Loading this file will automatically initialize the scripts. This way the scrolling works just by adding it.
 */

/**
 * Initializes the smooth scrolling.
 *
 * All internal links will use the smooth scrolling.
 */
$(window).load(function () {
    $('a[href^="#"]').on('click', function (e) {

        // Prevents default anchor click behavior
        e.preventDefault();

        var hash = this.hash;
        var offset = $(hash).offset();
        if(offset){
            $('html, body').animate({
                scrollTop: $(hash).offset().top
            }, 300, function () {
                // After ending, the hash is added to the URL
                window.location.hash = hash;
            });
        }

    });
});