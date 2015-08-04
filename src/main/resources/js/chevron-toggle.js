/**
 * Functions for toggling chevrons on menus, so they indicate if the menu is deployed or not.
 *
 * This is purely for visual purposes. While chevrons help to indicate a menu option can be opened, animating them
 * just looks good.
 *
 * Currently only dropdown menus are supported, and they should be marked with the .chevron_toggleable class. Also
 * they should use the Font Awesome chevrons, and Bootstrap CSS classes.
 *
 * The way the chevrons work is simple: the one pointing up indicates the menu is closed, while the one pointing down
 * indicates it is open. All menus should have the closed chevron by default on the html file.
 *
 * Loading this file will automatically initialize the scripts. This way the menus work just by adding it.
 */

/**
 * Initializes the chevron toggling.
 *
 * This will prepare only the dropdown menus.
 */
$(document).ready(function () {

    $('.dropdown').on('show.bs.dropdown', toggleDropdownChevronOpen);

    $('.dropdown').on('hide.bs.dropdown', toggleDropdownChevronClosed);

});

/**
 * Toggles the chevron on the active dropdown menu, so it points down, indicating it is open.
 */
function toggleDropdownChevronOpen() {
    $(this).find('.chevron_toggleable')
        .removeClass("fa fa-chevron-up")
        .addClass("fa fa-chevron-down");
}

/**
 * Toggles the chevron on the active dropdown menu, so it points up, indicating it is closed.
 */
function toggleDropdownChevronClosed() {
    $(this).find('.chevron_toggleable')
        .removeClass("fa fa-chevron-down")
        .addClass("fa fa-chevron-up");
}