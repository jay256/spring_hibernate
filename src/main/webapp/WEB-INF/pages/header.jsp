
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/images/icons/btlogonew_favicon.ico" />
<link rel="stylesheet" href="https://app.divshot.com/css/bootstrap.css">
<link rel="stylesheet" href="https://app.divshot.com/css/bootstrap-responsive.css">


<script src="https://app.divshot.com/js/jquery.min.js"></script>
<script src="https://app.divshot.com/js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css" type="text/css" />
<link type="text/css" href="<%=request.getContextPath()%>/resources/css/ui.multiselect.css" rel="stylesheet" />
<link type="text/css" href="<%=request.getContextPath()%>/resources/css/jquery.ui.css" rel="stylesheet" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.10/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/plugins/localisation/jquery.localisation-min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/plugins/scrollTo/jquery.scrollTo-min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/ui.multiselect.js"></script>
<script type="text/javascript">
    window.onload = function() {
        fixBrokenImages('<%=request.getContextPath()%>/resources/images/employee1_pic.png');
    }
    fixBrokenImages = function(url) {
        var img = document.getElementsByTagName('img');
        var i = 0, l = img.length;
        for (; i < l; i++) {
            var t = img[i];
            if (t.naturalWidth === 0) {
                //this image is broken
                t.src = url;
            }
        }
    }
</script>