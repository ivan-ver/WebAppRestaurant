let modal =(function () {
    let $window = $(window);
    let $modal = $('<div class="modal"/>');
    let $content = $('<div class="modal-content"/>');
    let $close = $('<button role="button" class="modal-close">close</button>');
    let $overlay = $('<div id="overlay"></div>');

    $modal.append($content,$close);


    $close.on('click',function (e) {
        e.preventDefault();
        modal.close();
    });

    return {
        center: function () {
            let top = Math.max($window.height() - $modal.outerHeight(),0)/2;
            let left = Math.max($window.width() - $modal.outerWidth(),0)/2;
            $modal.css({
                top: top+$window.scrollTop(),
                left: left+$window.scrollLeft(),
            })
        },

        open: function (settings) {
            $('body').append($overlay);
            $overlay.fadeIn(400);
            $content.empty().append((settings.content));
            $modal.css({
                width: settings.width || 'auto',
                height: settings.height || 'auto',
            }).appendTo('body');

            modal.center();
            $(window).on('resize',modal.center);
        },

        close: function () {
            $overlay.fadeOut(400);
            $content.empty();
            $overlay.detach();
            $modal.detach();
            $(window).off('resize',modal.center);
        }
    };
}());

