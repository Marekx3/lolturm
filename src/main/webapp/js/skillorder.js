var levels = ["level1", "level2", "level3", "level4", "level5", "level6",
    "level7", "level8", "level9", "level10", "level11", "level12",
    "level13", "level14", "level15", "level16", "level17", "level18"];

var q = 0;
var w = 0;
var e = 0;
var r = 0;

var row = 2;

$(document).ready(function () {
    for (var i = 1; i <= 72; i++) {
        if (i == 1 || i == 19 || i == 37) {
            click(i);
        } else {
            disable(i);
            click(i)
        }
    }
});

function disable(button) {
    $('#' + button).attr("disabled", true);
}

function enable(button) {
    $('#' + button).attr("disabled", false);
}

function unckeck(button) {
    $('#' + button).attr("checked", false);
}

function click(button) {
    $('.' + button).before($('.' + button).click(function () {
        for (var j = 1; j <= 72; j++) {
            if (button == j || button == j + 18 || button == j + 18 + 18) {
                for (var i = button; i < 72; i++) {
                    unckeck(i + 1);
                    row = 2;
                }
                if (button == 5 || button == 5 + 18 || button == 5 + 18 + 18 || button == 10 || button == 10 + 18 || button == 10 + 18 + 18 || button == 15 || button == 15 + 18 || button == 15 + 18 + 18) {
                    var rowA = row;
                    for (var i = 1; i <= 4; i++) {
                        enable(rowA);
                        click(rowA);
                        rowA = rowA + 18;
                    }
                } else {
                    for (var i = 1; i <= 3; i++) {
                        enable(rowA);
                        click(rowA);
                        rowA = rowA + 18;
                    }
                }
                disable(button + 1);
                row++;
            }
        }
// var nextButton = button + 1;
// disable(nextButton);
// for (var i = 0; i < 3; i++) {
// enable(nextButton + 18);
// click(nextButton);
// nextButton = nextButton + 18;
// }
    }));
}