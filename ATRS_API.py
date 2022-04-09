#!/usr/bin/env python
# coding: utf-8

# In[ ]:


from flask import Flask
from flask_restful import Resource, Api, reqparse
from nsetools import Nse
from bsedata.bse import BSE
import json
import time
import threading

stocksList=[]
lock=threading.Lock()

def updateDataOnce():
    global stocksList
    nse=Nse()
    b=BSE()

    stocks = ['WIPRO', 'ICICIBANK', 'TATASTEEL', 'JSWSTEEL', 'HDFC', 'BPCL', 'BAJAJ-AUTO', 'ADANIPORTS', 'KOTAKBANK', 'HDFCBANK', 'SBIN', 'SBILIFE', 'BAJFINANCE', 'ITC', 'GRASIM', 'HEROMOTOCO', 'DRREDDY', 'AXISBANK', 'LT', 'COALINDIA', 'BRITANNIA', 'ONGC', 'RELIANCE', 'BAJAJFINSV', 'IOC', 'INFY', 'MARUTI', 'BHARTIARTL', 'HCLTECH', 'UPL', 'EICHERMOT', 'NTPC', 'POWERGRID', 'CIPLA', 'TCS', 'HDFCLIFE', 'DIVISLAB', 'HINDALCO', 'SUNPHARMA', 'INDUSINDBK', 'TATAMOTORS', 'M&M', 'ASIANPAINT', 'ULTRACEMCO', 'TECHM', 'NESTLEIND', 'HINDUNILVR', 'TATACONSUM', 'TITAN', 'SHREECEM']
    quotel= ["507685","532174","500470","500228","500010","500547","532977","532921","500247","500180","500112","540719","500034","500875","500300","500182","500124","532215","500510","533278","500825","500312","500325","532978","530965","500209","532500","532454","532281","512070","505200","532555","532898","500087","532540","540777","532488","500440","524715","532187","500570","500520","500820","532538","532755","500790","500696","500800","500114","500387"]
    #stocks =['WIPRO', 'ICICIBANK', 'TATASTEEL', 'JSWSTEEL', 'HDFC']
    #quotel = ["507685","532174","500470","500228","500010","500547","532977","532921","500247","500180"]
    q=[]
    rank=0

    for stock,code in zip(stocks,quotel):
        quote=b.getQuote(code) 
        rank+=1
        nsePrice = float(nse.get_quote(stock)['lastPrice'])
        bsePrice = float(quote["currentValue"])
        priceDiff = float(abs(nsePrice - bsePrice))
        percentDiff=0.0
        buy = ""
        if nsePrice < bsePrice:
            buy = "NSE"
            percentDiff = (priceDiff/nsePrice)*100
        else: 
            buy = "BSE"
            percentDiff = (priceDiff/bsePrice)*100
        q.append({"rank" : rank, "companyname" : stock, "nse": nsePrice, "bse":bsePrice, "priceDiff" : priceDiff, "buy" : buy, "percentDiff" : percentDiff})

    q = sorted(q, key=lambda k: k['percentDiff'], reverse=True)
    
    count=1
    for i in q:
        i['rank']=count
        count+=1
    lock.acquire()
    stocksList = list(q)
    lock.release()
    
def updateData():
    while True:
        updateDataOnce()
        time.sleep(1)
        
class Service(Resource):
     def get(self):
        lock.acquire()
        response = list(stocksList)
        lock.release()
        return response
        
class test(Resource):
    def get(self):
        return "testing"
    
app = Flask(__name__)
api = Api(app)

api.add_resource(Service, '/table')  

if __name__ == '__main__':
    print("Server is loading.....")
    updateDataOnce()
    print("Server is listening")
    t1 = threading.Thread(target=updateData, args=())
    t1.start()
    app.run()  # run our Flask app
   


# In[7]:





# In[ ]:




