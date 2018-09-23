var toolTipDiv = "runeTooltip";

$(document).ready(function() {
    $('#' + toolTipDiv).hide();
});

function hideDiv(toolTipDiv) {
    var div = $('#' + toolTipDiv);
    div.hide();
    div.html("");
}

function showDiv(toolTipDiv, event) {
    var div = $('#' + toolTipDiv);
    div.show();
    div.html(text(event));
}

function moveDiv(toolTipDiv, event) {
    var div = $('#' + toolTipDiv);

    var x = event.screenX + 1200 + 175;
    var y = event.screenY + 190;

    div.offset({top: y, left: x});
}

function text(event) {
    var imgSrc = event.path[0].src;
    var lastSlashPos = imgSrc.lastIndexOf("/");
    var imgName = imgSrc.substring(lastSlashPos + 1, imgSrc.length - 4);
    var desc = getDesc(imgName);
    return desc;
}

function getDesc(imgName) {
    $.getJSON("/lolturm/json/runes.json", function (data) {
        var items = [];
        $.each(data, function (key, val) {
            if (data[key].name == imgName) {
                items.push("<li id='" + data[key].name + "'>" + data[key].desc + "</li>");
            }
        });

        $("<ul/>", {
            "class": "my-new-list",
            html: items.join("")
        }).appendTo("#runeTooltip");

        return items;
    });
}

