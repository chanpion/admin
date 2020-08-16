$(function(){
    $('ul.nav-sidebar li a').each(function () {
        if (this.href === window.location.href) {
            $(this).addClass('active');
        }
    });
})