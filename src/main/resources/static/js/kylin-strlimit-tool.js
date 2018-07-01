/**
 * Created by Threecolors on 2018/1/12.
 */
jQuery.fn.limit=function(){
    var self = $("[limit]");
    self.each(function(){
        var objString = $(this).html();
        var objLength = $(this).html().length;
        var num = $(this).attr("limit");
        if(objLength > num){
            $(this).attr("title",objString);
            $(this).html(objString.substring(0,num) + "...");
        }
    })
}
