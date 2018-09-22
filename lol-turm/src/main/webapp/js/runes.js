var selected = [];

var precision1 = ["PRESSTHEATTACK", "LETHALTEMPO", "FLEETFOOTWORK"];
var precision2 = ["OVERHEAL", "TRIUMPH", "PRESENCEOFMIND"];
var precision3 = ["LEGENDALACRITY", "LEGENDTENACITY", "LEGENDBLOODLINE"];
var precision4 = ["COUPDEGRACE", "CUTDOWN", "LASTSTAND"];

var domination1 = ["ELECTROCUTE", "PREDATOR", "DARKHARVEST"];
var domination2 = ["CHEAPSHOT", "TASTEOFBLOOD", "SUDDENIMPACT"];
var domination3 = ["ZOMBIEWARD", "GHOSTPORO", "EYEBALLCOLLECTION"];
var domination4 = ["RAVENOUSHUNTER", "INGENIOUSHUNTER", "RELENTLESSHUNTER"];

var sorcery1 = ["SUMMONAERY", "ARCANECOMET", "PHASERUSH"];
var sorcery2 = ["NULLIFYINGORB", "MANAFLOWBAND", "THEULTIMATEHAT"];
var sorcery3 = ["TRANSCENDENCE", "CELERITY", "ABSOLUTEFOCUS"];
var sorcery4 = ["SCORCH", "WATERWALKING", "GATHERINGSTORM"];

var resolve1 = ["GRASPOFTHEUNDYING", "AFTERSHOCK", "GUARDIAN"];
var resolve2 = ["DEMOLISH", "FONTOFLIFE", "BONEPLATING"];
var resolve3 = ["IRONSKIN", "MIRRORSHELL", "CONDITIONING"];
var resolve4 = ["OVERGROWTH", "REVITALIZE", "SECONDWIND"];

var inspiration1 = ["UNSEALEDSPELLBOOK", "GLACIALAUGMENT", "KLEPTOMANCY"];
var inspiration2 = ["HEXTECHFLASHTRAPTION", "BISCUITDELIVERY", "PERFECTTIMING"];
var inspiration3 = ["MAGICALFOOTWEAR", "FUTURESMARKET", "MINIONDEMATERIALIZER"];
var inspiration4 = ["COSMICINSIGH", "APPROACHVELOCITY", "TIMEWARPTONIC"];

var allRunes = [precision1, precision2, precision3, precision4, domination1, domination2, domination3, domination4, sorcery1, sorcery2, sorcery3, sorcery4, resolve1, resolve2, resolve3, resolve4, inspiration1, inspiration2, inspiration3, inspiration4];

var currentTree = "";

var lastClick = 0;

$(document).ready(function () {

    var keystone0Input = $('#keystone0Input').val();
    var keystone1Input = $('#keystone1Input').val();
    var keystone2Input = $('#keystone2Input').val();
    var keystone3Input = $('#keystone3Input').val();
    var firstSecondInput = $('#firstSecondInput').val();
    var secondSecondInput = $('#secondSecondInput').val();

    var selectedRunesArray = [keystone0Input, keystone1Input, keystone2Input, keystone3Input, firstSecondInput, secondSecondInput];

    $('#precisionSelect').hide();
    $('#dominationSelect').hide();
    $('#sorcerySelect').hide();
    $('#resolveSelect').hide();
    $('#inspirationSelect').hide();

    $('#precisionSecondTreeSelect').hide();
    $('#dominationSecondTreeSelect').hide();
    $('#sorcerySecondTreeSelect').hide();
    $('#resolveSecondTreeSelect').hide();
    $('#inspirationSecondTreeSelect').hide();

    var counter = 0;
    var eins = [];


    for (var k = 0; k < selectedRunesArray.length; k++) {
        if (k < 4) {
            if (selectedRunesArray[k] != "") {
//                console.log("click");
                var tree;
                var aRow;
                for (var i = 0; i < allRunes.length; i++) {
                    for (var j = 0; j < 3; j++) {
//                        console.log(allRunes[i][j]);
 //                       console.log(allRunes[i][j] == selectedRunesArray[k])
                        if (allRunes[i][j] === selectedRunesArray[k]) {
                            if (i == 0) {
                                $('#precisionSelect').show();
                                var aRow = varRowChecker(i, "Precision");
                                buttonProperties(j, aRow);
                                i = 20;
                                j = 4;
                            }
                            if (i == 1 || i == 2 || i == 3) {
                                var aRow = varRowChecker(i, "Precision");
                                buttonProperties(j, aRow);
                                i = 20;
                                j = 4;
                            }
                            if (i == 4) {
                                $('#dominationSelect').show();
                                var aRow = varRowChecker(i-4, "Domination");
                                buttonProperties(j, aRow);
                                i = 20;
                                j = 4;
                            }
                            if (i == 5 || i == 6 || i == 7) {
                                $('#dominationSelect').show();
                                var aRow = varRowChecker(i-4, "Domination");
                                buttonProperties(j, aRow);
                                i = 20;
                                j = 4;
                            }
                            if (i == 8) {
                                $('#sorcerySelect').show();
                                var aRow = varRowChecker(i-8, "Sorcery");
                                buttonProperties(j, aRow);
                                i = 20;
                                j = 4;
                            }
                            if (i == 9 || i == 10 || i == 11) {
                                $('#sorcerySelect').show();
                                var aRow = varRowChecker(i-8, "Sorcery");
                                buttonProperties(j, aRow);
                                i = 20;
                                j = 4;
                            }
                            if (i == 12) {
                                $('#resolveSelect').show();
                                var aRow = varRowChecker(i-12, "Resolve");
                                buttonProperties(j, aRow);
                                i = 20;
                                j = 4;
                            }
                            if (i == 13 || i == 14 || i == 15) {
                                $('#resolveSelect').show();
                                var aRow = varRowChecker(i-12, "Resolve");
                                buttonProperties(j, aRow);
                                i = 20;
                                j = 4;
                            }
                            if (i == 16) {
                                $('#inspirationSelect').show();
                                var aRow = varRowChecker(i-16, "Inspiration");
                                buttonProperties(j, aRow);
                                i = 20;
                                j = 4;
                            }
                            if (i == 17 || i == 18 || i == 19) {
                                $('#inspirationSelect').show();
                                var aRow = varRowChecker(i-16, "Inspiration");
                                buttonProperties(j, aRow);
                                i = 20;
                                j = 4;
                            }
                        }
                    }
                }
            }
        } else if (k < 6 && k > 3) {
            if (selectedRunesArray[k] != "") {
                var tree;
                var aRow;
                for (var i = 0; i < allRunes.length; i++) {
                    for (var j = 0; j < 3; j++) {
//                        console.log(allRunes[i][j]);
//                        console.log(allRunes[i][j] == selectedRunesArray[k])
                        if (allRunes[i][j] === selectedRunesArray[k]) {
                            if (i == 1 || i == 2 || i == 3) {
                                $('#precisionSecondTreeSelect').show();
                                var aRow = varRowChecker(i, "Precision");
                                buttonProperties(j, aRow);

                                eins[counter] = i;
                                counter++;

                                tree = "Precision";

                                i = 20;
                                j = 4;
                            }
                            if (i == 5 || i == 6 || i == 7) {
                                $('#dominationSecondTreeSelect').show();
                                var aRow = varRowChecker(i-3, "Domination");
                                buttonProperties(j, aRow);

                                eins[counter] = i-3;
                                counter++;

                                tree = "Domination";

                                i = 20;
                                j = 4;
                            }
                            if (i == 9 || i == 10 || i == 11) {
                                $('#sorcerySecondTreeSelect').show();
                                var aRow = varRowChecker(i-8, "Sorcery");
                                buttonProperties(j, aRow);

                                eins[counter] = i-8;
                                counter++;

                                tree = "Sorcery";

                                i = 20;
                                j = 4;
                            }
                            if (i == 13 || i == 14 || i == 15) {
                                $('#resolveSecondTreeSelect').show();
                                var aRow = varRowChecker(i-12, "Resolve");
                                buttonProperties(j, aRow);

                                eins[counter] = i-12;
                                counter++;

                                tree = "Resolve";

                                i = 20;
                                j = 4;
                            }
                            if (i == 17 || i == 18 || i == 19) {
                                $('#inspirationSecondTreeSelect').show();
                                var aRow = varRowChecker(i-16, "Inspiration");
                                buttonProperties(j, aRow);

                                eins[counter] = i-16;
                                counter++;

                                tree = "Inspiration";

                                i = 20;
                                j = 4;
                            }
                        }
                    }
                }
//                console.log("---------------------------------------------------------------------------------------------");

                var notUsedRowZiffer = notUsedRow(eins[0], eins[1]);
//                console.log(notUsedRowZiffer + "------------------------------------------------------------------------------------------" + eins);
//                console.log(eins);

                var notUsedRowaRow = varRowChecker(notUsedRowZiffer, tree);
                deactiveRow(notUsedRowaRow);
            }
        }
    }


    //--------------------------------KEYSTONE---------------------------------------------------

    $('#PrecisionKeystone').click(function () {
        selected = [];

        currentTree = "Precision";

        $('#precisionSelect').show();
        $('#dominationSelect').hide();
        $('#sorcerySelect').hide();
        $('#resolveSelect').hide();
        $('#inspirationSelect').hide();

        $('#precisionSecondTreeSelect').hide();
        $('#dominationSecondTreeSelect').hide();
        $('#sorcerySecondTreeSelect').hide();
        $('#resolveSecondTreeSelect').hide();
        $('#inspirationSecondTreeSelect').hide();

        $('#keystone0Input').val(selected[0]);
        $('#keystone1Input').val(selected[1]);
        $('#keystone2Input').val(selected[2]);
        $('#keystone3Input').val(selected[3]);
        
        $('#keystoneId').val(1);
        $('#secondTreeId').val("");

        deactiveAll(allRunes);
    });
    $('#DominationKeystone').click(function () {
        selected = [];

        currentTree = "Domination";

        $('#precisionSelect').hide();
        $('#dominationSelect').show();
        $('#sorcerySelect').hide();
        $('#resolveSelect').hide();
        $('#inspirationSelect').hide();

        $('#precisionSecondTreeSelect').hide();
        $('#dominationSecondTreeSelect').hide();
        $('#sorcerySecondTreeSelect').hide();
        $('#resolveSecondTreeSelect').hide();
        $('#inspirationSecondTreeSelect').hide();

        $('#keystone0Input').val(selected[0]);
        $('#keystone1Input').val(selected[1]);
        $('#keystone2Input').val(selected[2]);
        $('#keystone3Input').val(selected[3]);
        
        $('#keystoneId').val(2);
        $('#secondTreeId').val("");

        deactiveAll(allRunes);
    });
    $('#SorceryKeystone').click(function () {
        selected = [];

        currentTree = "Sorcery";

        $('#precisionSelect').hide();
        $('#dominationSelect').hide();
        $('#sorcerySelect').show();
        $('#resolveSelect').hide();
        $('#inspirationSelect').hide();

        $('#precisionSecondTreeSelect').hide();
        $('#dominationSecondTreeSelect').hide();
        $('#sorcerySecondTreeSelect').hide();
        $('#resolveSecondTreeSelect').hide();
        $('#inspirationSecondTreeSelect').hide();

        $('#keystone0Input').val(selected[0]);
        $('#keystone1Input').val(selected[1]);
        $('#keystone2Input').val(selected[2]);
        $('#keystone3Input').val(selected[3]);
        
        $('#keystoneId').val(3);
        $('#secondTreeId').val("");

        deactiveAll(allRunes);
    });
    $('#ResolveKeystone').click(function () {
        selected = [];

        currentTree = "Resolve";

        $('#precisionSelect').hide();
        $('#dominationSelect').hide();
        $('#sorcerySelect').hide();
        $('#resolveSelect').show();
        $('#inspirationSelect').hide();

        $('#precisionSecondTreeSelect').hide();
        $('#dominationSecondTreeSelect').hide();
        $('#sorcerySecondTreeSelect').hide();
        $('#resolveSecondTreeSelect').hide();
        $('#inspirationSecondTreeSelect').hide();

        $('#keystone0Input').val(selected[0]);
        $('#keystone1Input').val(selected[1]);
        $('#keystone2Input').val(selected[2]);
        $('#keystone3Input').val(selected[3]);
        
        $('#keystoneId').val(4);
        $('#secondTreeId').val("");

        deactiveAll(allRunes);
    });
    $('#InspirationKeystone').click(function () {
        selected = [];

        currentTree = "Inspiration";

        $('#precisionSelect').hide();
        $('#dominationSelect').hide();
        $('#sorcerySelect').hide();
        $('#resolveSelect').hide();
        $('#inspirationSelect').show();

        $('#precisionSecondTreeSelect').hide();
        $('#dominationSecondTreeSelect').hide();
        $('#sorcerySecondTreeSelect').hide();
        $('#resolveSecondTreeSelect').hide();
        $('#inspirationSecondTreeSelect').hide();

        $('#keystone0Input').val(selected[0]);
        $('#keystone1Input').val(selected[1]);
        $('#keystone2Input').val(selected[2]);
        $('#keystone3Input').val(selected[3]);
        
        $('#keystoneId').val(5);
        $('#secondTreeId').val("");

        deactiveAll(allRunes);
    });
//------------------------------SECOND TREE----------------------------------------
    $('#PrecisionSecondTree').click(function () {
        selected = [];

        if (currentTree != "") {
            if (currentTree != "Precision") {
                $('#precisionSecondTreeSelect').show();
                $('#dominationSecondTreeSelect').hide();
                $('#sorcerySecondTreeSelect').hide();
                $('#resolveSecondTreeSelect').hide();
                $('#inspirationSecondTreeSelect').hide();
                
                $('#secondTreeId').val(1);
            }
        }

        $('#firstSecondInput').val("");
        $('#secondSecondInput').val("");
    });
    $('#DominationSecondTree').click(function () {
        selected = [];

        if (currentTree != "") {
            if (currentTree != "Domination") {
                $('#precisionSecondTreeSelect').hide();
                $('#dominationSecondTreeSelect').show();
                $('#sorcerySecondTreeSelect').hide();
                $('#resolveSecondTreeSelect').hide();
                $('#inspirationSecondTreeSelect').hide();
                
                $('#secondTreeId').val(2);
            }
        }

        $('#firstSecondInput').val("");
        $('#secondSecondInput').val("");
    });
    $('#SorcerySecondTree').click(function () {
        selected = [];

        if (currentTree != "") {
            if (currentTree != "Sorcery") {
                $('#precisionSecondTreeSelect').hide();
                $('#dominationSecondTreeSelect').hide();
                $('#sorcerySecondTreeSelect').show();
                $('#resolveSecondTreeSelect').hide();
                $('#inspirationSecondTreeSelect').hide();
                
                $('#secondTreeId').val(3);
            }
        }

        $('#firstSecondInput').val("");
        $('#secondSecondInput').val("");
    });
    $('#ResolveSecondTree').click(function () {
        selected = [];

        if (currentTree != "") {
            if (currentTree != "Resolve") {
                $('#precisionSecondTreeSelect').hide();
                $('#dominationSecondTreeSelect').hide();
                $('#sorcerySecondTreeSelect').hide();
                $('#resolveSecondTreeSelect').show();
                $('#inspirationSecondTreeSelect').hide();
                
                $('#secondTreeId').val(4);
            }
        }

        $('#firstSecondInput').val("");
        $('#secondSecondInput').val("");
    });
    $('#InspirationSecondTree').click(function () {
        selected = [];

        if (currentTree != "") {
            if (currentTree != "Inspiration") {
                $('#precisionSecondTreeSelect').hide();
                $('#dominationSecondTreeSelect').hide();
                $('#sorcerySecondTreeSelect').hide();
                $('#resolveSecondTreeSelect').hide();
                $('#inspirationSecondTreeSelect').show();
                
                $('#secondTreeId').val(5);
            }
        }

        $('#firstSecondInput').val("");
        $('#secondSecondInput').val("");
    });

//--------------------------------------------------------------------

    precision();
    precisionSecondTree();
    dominaiton();
    dominationSecondTree();
    sorcery();
    sorcerySecondTree();
    resolve();
    resolveSecondTree();
    inspiration();
    inspirationSecondTree();

});

function precision() {
    for (var i = 0; i < precision1.length; i++) {
        if ('#' + precision1[i] == '#' + precision1[0]) {
            $('#' + precision1[i]).click(function () {
                keystone(0, 0, "Precision");
            });
        } else if ('#' + precision1[i] == '#' + precision1[1]) {
            $('#' + precision1[i]).click(function () {
                keystone(0, 1, "Precision");
            });
        } else if ('#' + precision1[i] == '#' + precision1[2]) {
            $('#' + precision1[i]).click(function () {
                keystone(0, 2, "Precision");
            });
        }
    }
    for (var i = 0; i < precision2.length; i++) {
        if ('#' + precision2[i] == '#' + precision2[0]) {
            $('#' + precision2[i]).click(function () {
                keystone(1, 0, "Precision");
            });
        } else if ('#' + precision2[i] == '#' + precision2[1]) {
            $('#' + precision2[i]).click(function () {
                keystone(1, 1, "Precision");
            });
        } else if ('#' + precision2[i] == '#' + precision2[2]) {
            $('#' + precision2[i]).click(function () {
                keystone(1, 2, "Precision");
            });
        }
    }
    for (var i = 0; i < precision3.length; i++) {
        if ('#' + precision3[i] == '#' + precision3[0]) {
            $('#' + precision3[i]).click(function () {
                keystone(2, 0, "Precision");
            });
        } else if ('#' + precision3[i] == '#' + precision3[1]) {
            $('#' + precision3[i]).click(function () {
                keystone(2, 1, "Precision");
            });
        } else if ('#' + precision3[i] == '#' + precision3[2]) {
            $('#' + precision3[i]).click(function () {
                keystone(2, 2, "Precision");
            });
        }
    }
    for (var i = 0; i < precision4.length; i++) {
        if ('#' + precision4[i] == '#' + precision4[0]) {
            $('#' + precision4[i]).click(function () {
                keystone(3, 0, "Precision");
            });
        } else if ('#' + precision4[i] == '#' + precision4[1]) {
            $('#' + precision4[i]).click(function () {
                keystone(3, 1, "Precision");
            });
        }
        else if ('#' + precision4[i] == '#' + precision4[2]) {
            $('#' + precision4[i]).click(function () {
                keystone(3, 2, "Precision");
            });
        }
    }
}

function dominaiton() {
    for (var i = 0; i < domination1.length; i++) {
        if ('#' + domination1[i] == '#' + domination1[0]) {
            $('#' + domination1[i]).click(function () {
                keystone(0, 0, "Domination");

            });
        } else if ('#' + domination1[i] == '#' + domination1[1]) {
            $('#' + domination1[i]).click(function () {
                keystone(0, 1, "Domination");

            });
        } else if ('#' + domination1[i] == '#' + domination1[2]) {
            $('#' + domination1[i]).click(function () {
                keystone(0, 2, "Domination");

            });
        }
    }
    for (var i = 0; i < domination2.length; i++) {
        if ('#' + domination2[i] == '#' + domination2[0]) {
            $('#' + domination2[i]).click(function () {
                keystone(1, 0, "Domination");
            });
        } else if ('#' + domination2[i] == '#' + domination2[1]) {
            $('#' + domination2[i]).click(function () {
                keystone(1, 1, "Domination");
            });
        } else if ('#' + domination2[i] == '#' + domination2[2]) {
            $('#' + domination2[i]).click(function () {
                keystone(1, 2, "Domination");
            });
        }
    }
    for (var i = 0; i < domination3.length; i++) {
        if ('#' + domination3[i] == '#' + domination3[0]) {
            $('#' + domination3[i]).click(function () {
                keystone(2, 0, "Domination");
            });
        } else if ('#' + domination3[i] == '#' + domination3[1]) {
            $('#' + domination3[i]).click(function () {
                keystone(2, 1, "Domination");
            });
        } else if ('#' + domination3[i] == '#' + domination3[2]) {
            $('#' + domination3[i]).click(function () {
                keystone(2, 2, "Domination");
            });
        }
    }
    for (var i = 0; i < domination4.length; i++) {
        if ('#' + domination4[i] == '#' + domination4[0]) {
            $('#' + domination4[i]).click(function () {
                keystone(3, 0, "Domination");
            });
        } else if ('#' + domination4[i] == '#' + domination4[1]) {
            $('#' + domination4[i]).click(function () {
                keystone(3, 1, "Domination");
            });
        } else if ('#' + domination4[i] == '#' + domination4[2]) {
            $('#' + domination4[i]).click(function () {
                keystone(3, 2, "Domination");
            });
        }
    }
}

function sorcery() {
    for (var i = 0; i < sorcery1.length; i++) {
        if ('#' + sorcery1[i] == '#' + sorcery1[0]) {
            $('#' + sorcery1[i]).click(function () {
                keystone(0, 0, "Sorcery");
            });
        } else if ('#' + sorcery1[i] == '#' + sorcery1[1]) {
            $('#' + sorcery1[i]).click(function () {
                keystone(0, 1, "Sorcery");
            });
        } else if ('#' + sorcery1[i] == '#' + sorcery1[2]) {
            $('#' + sorcery1[i]).click(function () {
                keystone(0, 2, "Sorcery");
            });
        }
    }
    for (var i = 0; i < sorcery2.length; i++) {
        if ('#' + sorcery2[i] == '#' + sorcery2[0]) {
            $('#' + sorcery2[i]).click(function () {
                keystone(1, 0, "Sorcery");
            });
        } else if ('#' + sorcery2[i] == '#' + sorcery2[1]) {
            $('#' + sorcery2[i]).click(function () {
                keystone(1, 1, "Sorcery");
            });
        } else if ('#' + sorcery2[i] == '#' + sorcery2[2]) {
            $('#' + sorcery2[i]).click(function () {
                keystone(1, 2, "Sorcery");
            });
        }
    }
    for (var i = 0; i < sorcery3.length; i++) {
        if ('#' + sorcery3[i] == '#' + sorcery3[0]) {
            $('#' + sorcery3[i]).click(function () {
                keystone(2, 0, "Sorcery");
            });
        } else if ('#' + sorcery3[i] == '#' + sorcery3[1]) {
            $('#' + sorcery3[i]).click(function () {
                keystone(2, 1, "Sorcery");
            });
        } else if ('#' + sorcery3[i] == '#' + sorcery3[2]) {
            $('#' + sorcery3[i]).click(function () {
                keystone(2, 2, "Sorcery");
            });
        }
    }
    for (var i = 0; i < sorcery4.length; i++) {
        if ('#' + sorcery4[i] == '#' + sorcery4[0]) {
            $('#' + sorcery4[i]).click(function () {
                keystone(3, 0, "Sorcery");
            });
        } else if ('#' + sorcery4[i] == '#' + sorcery4[1]) {
            $('#' + sorcery4[i]).click(function () {
                keystone(3, 1, "Sorcery");
            });
        } else if ('#' + sorcery4[i] == '#' + sorcery4[2]) {
            $('#' + sorcery4[i]).click(function () {
                keystone(3, 2, "Sorcery");
            });
        }
    }
}

function resolve() {
    for (var i = 0; i < resolve1.length; i++) {
        if ('#' + resolve1[i] == '#' + resolve1[0]) {
            $('#' + resolve1[i]).click(function () {
                keystone(0, 0, "Resolve");
            });
        } else if ('#' + resolve1[i] == '#' + resolve1[1]) {
            $('#' + resolve1[i]).click(function () {
                keystone(0, 1, "Resolve");
            });
        } else if ('#' + resolve1[i] == '#' + resolve1[2]) {
            $('#' + resolve1[i]).click(function () {
                keystone(0, 2, "Resolve");
            });
        }
    }
    for (var i = 0; i < resolve2.length; i++) {
        if ('#' + resolve2[i] == '#' + resolve2[0]) {
            $('#' + resolve2[i]).click(function () {
                keystone(1, 0, "Resolve");
            });
        } else if ('#' + resolve2[i] == '#' + resolve2[1]) {
            $('#' + resolve2[i]).click(function () {
                keystone(1, 1, "Resolve");
            });
        } else if ('#' + resolve2[i] == '#' + resolve2[2]) {
            $('#' + resolve2[i]).click(function () {
                keystone(1, 2, "Resolve");
            });
        }
    }
    for (var i = 0; i < resolve3.length; i++) {
        if ('#' + resolve3[i] == '#' + resolve3[0]) {
            $('#' + resolve3[i]).click(function () {
                keystone(2, 0, "Resolve");
            });
        } else if ('#' + resolve3[i] == '#' + resolve3[1]) {
            $('#' + resolve3[i]).click(function () {
                keystone(2, 1, "Resolve");
            });
        } else if ('#' + resolve3[i] == '#' + resolve3[2]) {
            $('#' + resolve3[i]).click(function () {
                keystone(2, 2, "Resolve");
            });
        }
    }
    for (var i = 0; i < resolve4.length; i++) {
        if ('#' + resolve4[i] == '#' + resolve4[0]) {
            $('#' + resolve4[i]).click(function () {
                keystone(3, 0, "Resolve");
            });
        } else if ('#' + resolve4[i] == '#' + resolve4[1]) {
            $('#' + resolve4[i]).click(function () {
                keystone(3, 1, "Resolve");
            });
        } else if ('#' + resolve4[i] == '#' + resolve4[2]) {
            $('#' + resolve4[i]).click(function () {
                keystone(3, 2, "Resolve");
            });
        }
    }
}

function inspiration() {
    for (var i = 0; i < inspiration1.length; i++) {
        if ('#' + inspiration1[i] == '#' + inspiration1[0]) {
            $('#' + inspiration1[i]).click(function () {
                keystone(0, 0, "Inspiration");
            });
        } else if ('#' + inspiration1[i] == '#' + inspiration1[1]) {
            $('#' + inspiration1[i]).click(function () {
                keystone(0, 1, "Inspiration");
            });
        } else if ('#' + inspiration1[i] == '#' + inspiration1[2]) {
            $('#' + inspiration1[i]).click(function () {
                keystone(0, 2, "Inspiration");
            });
        }
    }
    for (var i = 0; i < inspiration2.length; i++) {
        if ('#' + inspiration2[i] == '#' + inspiration2[0]) {
            $('#' + inspiration2[i]).click(function () {
                keystone(1, 0, "Inspiration");
            });
        } else if ('#' + inspiration2[i] == '#' + inspiration2[1]) {
            $('#' + inspiration2[i]).click(function () {
                keystone(1, 1, "Inspiration");
            });
        } else if ('#' + inspiration2[i] == '#' + inspiration2[2]) {
            $('#' + inspiration2[i]).click(function () {
                keystone(1, 2, "Inspiration");
            });
        }
    }
    for (var i = 0; i < inspiration3.length; i++) {
        if ('#' + inspiration3[i] == '#' + inspiration3[0]) {
            $('#' + inspiration3[i]).click(function () {
                keystone(2, 0, "Inspiration");
            });
        } else if ('#' + inspiration3[i] == '#' + inspiration3[1]) {
            $('#' + inspiration3[i]).click(function () {
                keystone(2, 1, "Inspiration");
            });
        } else if ('#' + inspiration3[i] == '#' + inspiration3[2]) {
            $('#' + inspiration3[i]).click(function () {
                keystone(2, 2, "Inspiration");
            });
        }
    }
    for (var i = 0; i < inspiration4.length; i++) {
        if ('#' + inspiration4[i] == '#' + inspiration4[0]) {
            $('#' + inspiration4[i]).click(function () {
                keystone(3, 0, "Inspiration");
            });
        } else if ('#' + inspiration4[i] == '#' + inspiration4[1]) {
            $('#' + inspiration4[i]).click(function () {
                keystone(3, 1, "Inspiration");
            });
        } else if ('#' + inspiration4[i] == '#' + inspiration4[2]) {
            $('#' + inspiration4[i]).click(function () {
                keystone(3, 2, "Inspiration");
            });
        }
    }
}

function precisionSecondTree() {
    for (var i = 0; i < precision2.length; i++) {
        if ('.' + precision2[i] == '.' + precision2[0]) {
            $('.' + precision2[i]).click(function () {
                secondTree(1, 0, "Precision");
            });
        } else if ('.' + precision2[i] == '.' + precision2[1]) {
            $('.' + precision2[i]).click(function () {
                secondTree(1, 1, "Precision");
            });
        } else if ('.' + precision2[i] == '.' + precision2[2]) {
            $('.' + precision2[i]).click(function () {
                secondTree(1, 2, "Precision");
            });
        }
    }
    for (var i = 0; i < precision3.length; i++) {
        if ('.' + precision3[i] == '.' + precision3[0]) {
            $('.' + precision3[i]).click(function () {
                secondTree(2, 0, "Precision");
            });
        } else if ('.' + precision3[i] == '.' + precision3[1]) {
            $('.' + precision3[i]).click(function () {
                secondTree(2, 1, "Precision");
            });
        } else if ('.' + precision3[i] == '.' + precision3[2]) {
            $('.' + precision3[i]).click(function () {
                secondTree(2, 2, "Precision");
            });
        }
    }
    for (var i = 0; i < precision4.length; i++) {
        if ('.' + precision4[i] == '.' + precision4[0]) {
            $('.' + precision4[i]).click(function () {
                secondTree(3, 0, "Precision");
            });
        } else if ('.' + precision4[i] == '.' + precision4[1]) {
            $('.' + precision4[i]).click(function () {
                secondTree(3, 1, "Precision");
            });
        } else if ('.' + precision4[i] == '.' + precision4[2]) {
            $('.' + precision4[i]).click(function () {
                secondTree(3, 2, "Precision");
            });
        }
    }
}

function dominationSecondTree() {
    for (var i = 0; i < domination2.length; i++) {
        if ('.' + domination2[i] == '.' + domination2[0]) {
            $('.' + domination2[i]).click(function () {
                secondTree(1, 0, "Domination");
            });
        } else if ('.' + domination2[i] == '.' + domination2[1]) {
            $('.' + domination2[i]).click(function () {
                secondTree(1, 1, "Domination");
            });
        } else if ('.' + domination2[i] == '.' + domination2[2]) {
            $('.' + domination2[i]).click(function () {
                secondTree(1, 2, "Domination");
            });
        }
    }
    for (var i = 0; i < domination3.length; i++) {
        if ('.' + domination3[i] == '.' + domination3[0]) {
            $('.' + domination3[i]).click(function () {
                secondTree(2, 0, "Domination");
            });
        } else if ('.' + domination3[i] == '.' + domination3[1]) {
            $('.' + domination3[i]).click(function () {
                secondTree(2, 1, "Domination");
            });
        } else if ('.' + domination3[i] == '.' + domination3[2]) {
            $('.' + domination3[i]).click(function () {
                secondTree(2, 2, "Domination");
            });
        }
    }
    for (var i = 0; i < domination4.length; i++) {
        if ('.' + domination4[i] == '.' + domination4[0]) {
            $('.' + domination4[i]).click(function () {
                secondTree(3, 0, "Domination");
            });
        } else if ('.' + domination4[i] == '.' + domination4[1]) {
            $('.' + domination4[i]).click(function () {
                secondTree(3, 1, "Domination");
            });
        } else if ('.' + domination4[i] == '.' + domination4[2]) {
            $('.' + domination4[i]).click(function () {
                secondTree(3, 2, "Domination");
            });
        }
    }
}

function sorcerySecondTree() {
    for (var i = 0; i < sorcery2.length; i++) {
        if ('.' + sorcery2[i] == '.' + sorcery2[0]) {
            $('.' + sorcery2[i]).click(function () {
                secondTree(1, 0, "Sorcery");
            });
        } else if ('.' + sorcery2[i] == '.' + sorcery2[1]) {
            $('.' + sorcery2[i]).click(function () {
                secondTree(1, 1, "Sorcery");
            });
        } else if ('.' + sorcery2[i] == '.' + sorcery2[2]) {
            $('.' + sorcery2[i]).click(function () {
                secondTree(1, 2, "Sorcery");
            });
        }
    }
    for (var i = 0; i < sorcery3.length; i++) {
        if ('.' + sorcery3[i] == '.' + sorcery3[0]) {
            $('.' + sorcery3[i]).click(function () {
                secondTree(2, 0, "Sorcery");
            });
        } else if ('.' + sorcery3[i] == '.' + sorcery3[1]) {
            $('.' + sorcery3[i]).click(function () {
                secondTree(2, 1, "Sorcery");
            });
        } else if ('.' + sorcery3[i] == '.' + sorcery3[2]) {
            $('.' + sorcery3[i]).click(function () {
                secondTree(2, 2, "Sorcery");
            });
        }
    }
    for (var i = 0; i < sorcery4.length; i++) {
        if ('.' + sorcery4[i] == '.' + sorcery4[0]) {
            $('.' + sorcery4[i]).click(function () {
                secondTree(3, 0, "Sorcery");
            });
        } else if ('.' + sorcery4[i] == '.' + sorcery4[1]) {
            $('.' + sorcery4[i]).click(function () {
                secondTree(3, 1, "Sorcery");
            });
        } else if ('.' + sorcery4[i] == '.' + sorcery4[2]) {
            $('.' + sorcery4[i]).click(function () {
                secondTree(3, 2, "Sorcery");
            });
        }
    }
}

function resolveSecondTree() {
    for (var i = 0; i < resolve2.length; i++) {
        if ('.' + resolve2[i] == '.' + resolve2[0]) {
            $('.' + resolve2[i]).click(function () {
                secondTree(1, 0, "Resolve");
            });
        } else if ('.' + resolve2[i] == '.' + resolve2[1]) {
            $('.' + resolve2[i]).click(function () {
                secondTree(1, 1, "Resolve");
            });
        } else if ('.' + resolve2[i] == '.' + resolve2[2]) {
            $('.' + resolve2[i]).click(function () {
                secondTree(1, 2, "Resolve");
            });
        }
    }
    for (var i = 0; i < resolve3.length; i++) {
        if ('.' + resolve3[i] == '.' + resolve3[0]) {
            $('.' + resolve3[i]).click(function () {
                secondTree(2, 0, "Resolve");
            });
        } else if ('.' + resolve3[i] == '.' + resolve3[1]) {
            $('.' + resolve3[i]).click(function () {
                secondTree(2, 1, "Resolve");
            });
        } else if ('.' + resolve3[i] == '.' + resolve3[2]) {
            $('.' + resolve3[i]).click(function () {
                secondTree(2, 2, "Resolve");
            });
        }
    }
    for (var i = 0; i < resolve4.length; i++) {
        if ('.' + resolve4[i] == '.' + resolve4[0]) {
            $('.' + resolve4[i]).click(function () {
                secondTree(3, 0, "Resolve");
            });
        } else if ('.' + resolve4[i] == '.' + resolve4[1]) {
            $('.' + resolve4[i]).click(function () {
                secondTree(3, 1, "Resolve");
            });
        }
        else if ('.' + resolve4[i] == '.' + resolve4[2]) {
            $('.' + resolve4[i]).click(function () {
                secondTree(3, 2, "Resolve");
            });
        }
    }
}

function inspirationSecondTree() {
    for (var i = 0; i < inspiration2.length; i++) {
        if ('.' + inspiration2[i] == '.' + inspiration2[0]) {
            $('.' + inspiration2[i]).click(function () {
                secondTree(1, 0, "Inspiration");
            });
        } else if ('.' + inspiration2[i] == '.' + inspiration2[1]) {
            $('.' + inspiration2[i]).click(function () {
                secondTree(1, 1, "Inspiration");
            });
        } else if ('.' + inspiration2[i] == '.' + inspiration2[2]) {
            $('.' + inspiration2[i]).click(function () {
                secondTree(1, 2, "Inspiration");
            });
        }
    }
    for (var i = 0; i < inspiration3.length; i++) {
        if ('.' + inspiration3[i] == '.' + inspiration3[0]) {
            $('.' + inspiration3[i]).click(function () {
                secondTree(2, 0, "Inspiration");
            });
        } else if ('.' + inspiration3[i] == '.' + inspiration3[1]) {
            $('.' + inspiration3[i]).click(function () {
                secondTree(2, 1, "Inspiration");
            });
        } else if ('.' + inspiration3[i] == '.' + inspiration3[2]) {
            $('.' + inspiration3[i]).click(function () {
                secondTree(2, 2, "Inspiration");
            });
        }
    }
    for (var i = 0; i < inspiration4.length; i++) {
        if ('.' + inspiration4[i] == '.' + inspiration4[0]) {
            $('.' + inspiration4[i]).click(function () {
                secondTree(3, 0, "Inspiration");
            });
        } else if ('.' + inspiration4[i] == '.' + inspiration4[1]) {
            $('.' + inspiration4[i]).click(function () {
                secondTree(3, 1, "Inspiration");
            });
        } else if ('.' + inspiration4[i] == '.' + inspiration4[2]) {
            $('.' + inspiration4[i]).click(function () {
                secondTree(3, 2, "Inspiration");
            });
        }
    }
}

function active(idName) {
    $('#' + idName).css("filter", "none");
    $('.' + idName).css("filter", "none");
}

function deactive(idName) {
    $('#' + idName).css("filter", "grayscale(100%)");
    $('.' + idName).css("filter", "grayscale(100%)");
}

function deactiveAll(allRunes) {
    for (var i = 0; i < allRunes.length; i++) {
        for (var j = 0; j < 3; j++) {
            $('#' + allRunes[i][j]).css("filter", "none");
        }
    }
}

function keystone(row, column, tree) {
    var aRow = varRowChecker(row, tree);
    selected[column] = aRow[column];
    $('#keystone' + row + 'Input').val(selected[column]);
    buttonProperties(column, aRow);
}

function secondTree(row, column, tree) {
    var aRow = varRowChecker(row, tree);
    if (selected[4] == undefined) {
        selected[4] = [row, aRow[column]];
        $('#firstSecondInput').val(selected[4][1]);
        lastClick = 4;
        buttonProperties(column, aRow);
    } else if (selected[5] == undefined) {
        if (selected[4][0] == row) {
            selected[4][1] = aRow[column];
            $('#firstSecondInput').val(selected[4][1]);
            lastClick = 4;
            buttonProperties(column, aRow);
        } else {
            selected[5] = [row, aRow[column]];
            $('#secondSecondInput').val(selected[5][1]);
            lastClick = 5;
            buttonProperties(column, aRow);
            var eins = selected[4][0];
            var zwei = selected[5][0];
            var notUsedRowZiffer = notUsedRow(eins, zwei);
            var notUsedRowaRow = varRowChecker(notUsedRowZiffer, tree);
            deactiveRow(notUsedRowaRow);
        }
    } else if (selected[4][0] == row) {
        selected[4][1] = aRow[column];
        $('#firstSecondInput').val(selected[4][1]);
        lastClick = 4;
        buttonProperties(column, aRow);
    } else if (selected[4][0] != row) {
        if (selected[5][0] == row) {
            selected[5][1] = aRow[column];
            $('#secondSecondInput').val(selected[5][1]);
            lastClick = 5;
            buttonProperties(column, aRow);
        } else if (lastClick == 4) {
            selected[5] = [row, aRow[column]];
            $('#secondSecondInput').val(selected[5][1]);
            lastClick = 5;
            buttonProperties(column, aRow);
            var eins = selected[4][0];
            var zwei = selected[5][0];
            var notUsedRowZiffer = notUsedRow(eins, zwei);
            var notUsedRowaRow = varRowChecker(notUsedRowZiffer, tree);
            deactiveRow(notUsedRowaRow);
        } else if (lastClick == 5) {
            selected[4] = [row, aRow[column]];
            $('#firstSecondInput').val(selected[4][1]);
            lastClick = 4;
            buttonProperties(column, aRow);
            var eins = selected[4][0];
            var zwei = selected[5][0];
            var notUsedRowZiffer = notUsedRow(eins, zwei);
            var notUsedRowaRow = varRowChecker(notUsedRowZiffer, tree);
            deactiveRow(notUsedRowaRow);
        }
    }
}

function varRowChecker(row, tree) {
    var aRow = [];

    if (tree == "Precision") {
        if (row == 0) {
            aRow = precision1;
        } else if (row == 1) {
            aRow = precision2;
        } else if (row == 2) {
            aRow = precision3;
        } else if (row == 3) {
            aRow = precision4;
        }
    } else if (tree == "Domination") {
        if (row == 0) {
            aRow = domination1;
        } else if (row == 1) {
            aRow = domination2;
        } else if (row == 2) {
            aRow = domination3;
        } else if (row == 3) {
            aRow = domination4;
        }
    } else if (tree == "Sorcery") {
        if (row == 0) {
            aRow = sorcery1;
        } else if (row == 1) {
            aRow = sorcery2;
        } else if (row == 2) {
            aRow = sorcery3;
        } else if (row == 3) {
            aRow = sorcery4;
        }
    } else if (tree == "Resolve") {
        if (row == 0) {
            aRow = resolve1;
        } else if (row == 1) {
            aRow = resolve2;
        } else if (row == 2) {
            aRow = resolve3;
        } else if (row == 3) {
            aRow = resolve4;
        }
    } else if (tree == "Inspiration") {
        if (row == 0) {
            aRow = inspiration1;
        } else if (row == 1) {
            aRow = inspiration2;
        } else if (row == 2) {
            aRow = inspiration3;
        } else if (row == 3) {
            aRow = inspiration4;
        }
    }
    return aRow;
}

function buttonProperties(column, aRow) {
    active(aRow[column]);
    if (column == 0) {
        deactive(aRow[1]);
        deactive(aRow[2]);
    } else if (column == 1) {
        deactive(aRow[0]);
        deactive(aRow[2]);
    } else if (column == 2) {
        deactive(aRow[0]);
        deactive(aRow[1]);
    }
}

function deactiveRow(aRow) {
    deactive(aRow[0]);
    deactive(aRow[1]);
    deactive(aRow[2]);
}

function notUsedRow(first, second) {
    if (first == 1 && second == 2) {
        return 3;
    } else if (first == 2 && second == 1) {
        return 3;
    } else if (first == 1 && second == 3) {
        return 2;
    } else if (first == 3 && second == 1) {
        return 2;
    } else if (first == 2 && second == 3) {
        return 1;
    } else if (first == 3 && second == 2) {
        return 1;
    }
}