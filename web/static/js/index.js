$(function () {
    var $bswp2 = $('.banner-swiper2');
    var $bnccimg = $bswp2.find('img');
    var img = new Image();
    img.onload = function () {
        var swiper = new Swiper($bswp2, {
            effect: 'slide',
            loop: true,
            speed: 500,//切换速度
            watchSlidesProgress: true,
            centeredSlides: true,
            slidesPerView: 'auto',
            loopedSlides: 5,
            autoplay: {
                delay: 4000,//展示时间
                disableOnInteraction: false
            },
            navigation: {
                nextEl: '.swiper-button-next',
                prevEl: '.swiper-button-prev',
            },
            pagination: {
                el: '.swiper-pagination',
                clickable: true,
            },
            on: {
                progress: function (progress) {
                    var itemW = parseInt(this.slides.css('width'));
                    for (i = 0; i < this.slides.length; i++) {
                        var slide = this.slides.eq(i);
                        var slideProgress = this.slides[i].progress;
                        modify = 1;
                        if (Math.abs(slideProgress) > 1) {
                            modify = (Math.abs(slideProgress) - 1) * 0.15 + 1;
                        }
                        translate = slideProgress * modify * itemW / 1.5 + 'px';
                        var scaleSW = 1 - Math.abs(slideProgress) / 5;
                        zIndex = 999 - Math.abs(Math.round(10 * slideProgress));
                        slide.transform('translateX(' + translate + ') scale(' + scaleSW + ')');
                        slide.css('zIndex', zIndex);
                        slide.css('opacity', scaleSW);
                        if (Math.abs(slideProgress) > 5) {
                            slide.css('opacity', 0);
                        }
                    }
                },
                setTransition: function (transition) {
                    for (var i = 0; i < this.slides.length; i++) {
                        var slide = this.slides.eq(i);
                        slide.transition(transition);
                    }

                }
            }
        });
    }
    img.src = $bnccimg.attr("src");
});