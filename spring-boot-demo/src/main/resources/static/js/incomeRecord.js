function getIncomeRecord(){
     $.ajax({
             type:"GET",
             url:"/getIncome",
             data:{},
             dataType:"JSON",
             async:false,
             success:function(data) {
 document.getElementById("show_tbody").innerHTML="";
                var a=JSON.stringify(data);
                var b=eval("("+a+")");
                var result=b.result;

                 for(var i=0;i<result.length-1;i++){
                     var time=result[i].time;
                     var type=result[i].type;
                    if(type==0) {var Type=" Deposit"}
                     else {var Type=" Fine"}
                     var income=result[i].money;
                    /* 对字符串进行处理计算相应的收入 */


                     var html=           " <tr  >\n"+
                                             " <td>"+time+"</td>\n"+
                                             " <td>"+Type+"</td>\n"+
                                            "  <td>"+income+"</td>\n"+
                                        "  </tr>\n";

                                     document.getElementById("show_tbody").innerHTML = document.getElementById("show_tbody").innerHTML + html;
                 }
             }
         })
}

function DailyRecord(){

     $.ajax({
                 type:"GET",
                 url:"/getIncome",
                 data:{},
                 dataType:"JSON",
                 async:false,
                 success:function(data) {
     document.getElementById("show_tbody").innerHTML="";
                    var a=JSON.stringify(data);
                    var b=eval("("+a+")");
                    var result=b.result;

                     for(var i=0;i<result.length-1;i++){
                         var time=result[i].time;
                         var year=time.split("-")[0];
                         var month=time.split("-")[1];
                         var day=time.split("-")[2];
                         var Day=day.split(" ")[0];
                         var type=result[i].type;
                        if(type==0) {var Type="Total Deposit"}
                         else {var Type="Total Fine"}
                         var income=result[i].money;
                        /* 对字符串进行处理计算相应的收入 */


                         var html=           " <tr  >\n"+
                                                 " <td>"+year+"-"+month+"-"+Day+"</td>\n"+
                                                 " <td>"+Type+"</td>\n"+
                                                "  <td>"+income+"</td>\n"+
                                            "  </tr>\n";

                                         document.getElementById("show_tbody").innerHTML = document.getElementById("show_tbody").innerHTML + html;
                     }
                 }
             })
}



function MonthlyRecord(){

      $.ajax({
                  type:"GET",
                  url:"/getIncome",
                  data:{},
                  dataType:"JSON",
                  async:false,
                  success:function(data) {
      document.getElementById("show_tbody").innerHTML="";
                     var a=JSON.stringify(data);
                     var b=eval("("+a+")");
                     var result=b.result;
                     var income1=0;
                     var income2=0;
                      for(var i=0;i<result.length;i++){
                          var time=result[i].time;
                          var year=time.split("-")[0];
                          var month=time.split("-")[1];
                          var day=time.split("-")[2];
                          var type=result[i].type;
                         if(type==0) {var Type="Total Deposit"}
                          else {var Type="Total Fine"}
                          var income=result[i].money;

                         /* 对字符串进行处理计算相应的收入*/

                          if (month=='10')
                         {

                             if(type==0) income1=income1+income;
                             else income2=income2+income;
                             continue;
                         }

                          var html=       " <tr  >\n"+
                                                  " <td>"+year+"-"+'10'+"</td>\n"+
                                                  " <td>"+"Total Deposit "+"</td>\n"+
                                                 "  <td>"+income1+"</td>\n"+
                                             "  </tr>\n"+ " <tr  >\n"+
                                             " <td>"+year+"-"+'10'+"</td>\n"+
                                             " <td>"+" Total Fine"+"</td>\n"+
                                             "  <td>"+income2+"</td>\n"+
                                             "  </tr>\n";



                                          document.getElementById("show_tbody").innerHTML = document.getElementById("show_tbody").innerHTML + html;
                      }
                  }
              })
}


function WeeklyRecord(){

     $.ajax({
                 type:"GET",
                 url:"/getIncome",
                 data:{},
                 dataType:"JSON",
                 async:false,
                 success:function(data) {
     document.getElementById("show_tbody").innerHTML="";
                    var a=JSON.stringify(data);
                    var b=eval("("+a+")");
                    var result=b.result;
                    var Week=new Array();
                    var Income1=new Array();
                     Income1[0]=0;
                    var Income2=new Array();
                      Income2[0]=0;

                       Income1[1]=0;
                       Income1[2]=0;
                       Income1[3]=0;
                       Income1[4]=0;
                       Income1[5]=0;
                       Income1[6]=0;
                       Income2[1]=0;
                       Income2[2]=0;
                       Income2[3]=0;
                       Income2[4]=0;
                       Income2[5]=0;
                       Income2[6]=0;
                       Week[1]="First week     (10-01,10-07)";
                       Week[2]="Second week  (10-08,10-14)";
                       Week[3]="Third week  (10-15,10-21)";
                       Week[4]="Fourth week  (10-22,10-31)";
                       Week[5]="Fifth week  (11-01,11-07)";
                       Week[6]="Sixth week  (11-8,11-14)";



                     for(var i=0;i<result.length;i++){
                         var time=result[i].time;
                         var day=time.split("-")[2];
                         var year=time.split("-")[0];
                         var month=time.split("-")[1];
                         var day=time.split("-")[2];
                         var day1=day.split(" ")[0];
                         var Day=parseInt(day1);
                         var type=result[i].type;
                        if(type==0) {var Type="Total Deposit"}
                         else {var Type="Total Fine"}
                         var income=result[i].money;
                        /* 对字符串进行处理计算相应的收入 */
                     if(month=='10')
                   {


                     if( 1<=Day&&Day<=7 )
                                         {

                                             if(type==0)  Income1[1]+=income;
                                             else Income2[1]+=income;
                                             continue;
                                         }
                      if(8<=Day&&Day<=14)
                                          {

                                              if(type==0)  Income1[2]+=income;
                                              else Income2[2]+=income;
                                              continue;
                                          }

                       if(15<=Day&&Day<=21)
                                           {

                                               if(type==0)  Income1[3]+=income;
                                               else Income2[3]+=income;
                                               continue;
                                           }
                        if(22<=Day&&Day<=31)
                                            {

                                                if(type==0)  Income1[4]+=income;
                                                else Income2[4]+=income;
                                                continue;
                                            }
                    }

                       if(month=='11')
                         {

                           if(1<=Day&&Day<=7)
                                               {

                                                   if(type==0)  Income1[5]=0;
                                                   else Income2[5]=0;
                                                   continue;
                                               }
                            if(8<=Day&&Day<=14)
                                                {

                                                    if(type==0)  Income1[6]=0;
                                                    else Income2[6]=0;
                                                    continue;
                                                }


                          }


                     }

                     for( var j=1;j<5;j++)
                     {
                      var html=           " <tr  >\n"+
                                              " <td>"+ Week[j]+"</td>\n"+
                                              " <td>"+"Total Deposit"+"</td>\n"+
                                             "  <td>"+Income1[j]+"</td>\n"+
                                             "  </tr>\n"+
                                              " <tr  >\n"+
                                             " <td>"+ Week[j]+"</td>\n"+
                                             " <td>"+"Total Fine"+"</td>\n"+
                                            "  <td>"+Income2[j]+"</td>\n"+
                                            "  </tr>\n";


                   document.getElementById("show_tbody").innerHTML = document.getElementById("show_tbody").innerHTML + html;
                  }
                 }
             })
}










