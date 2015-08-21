#!/usr/bin/env python
#-*- coding: utf-8 -*-
'''
Created on 2014-11-12

@author: qxb
'''
import chardet
import util.time_parser as tp
import numpy as np
import os, sys, re, unittest
from util.active_func import *
import machinelearning.linearclassifier as lc
sys.path.append("../")
import jieba

def regressionTest():
    path = os.path.abspath(os.path.dirname(sys.argv[0]))
    print path
    files = os.listdir(path)
    test = re.compile("first.py", re.IGNORECASE)
    print test.search
    files = filter(test.search,files)
    
    filenameToModuleName = lambda f: os.path.splitext(f)[0]
    moduleNames = map(filenameToModuleName,files)
    modules = map(__import__,moduleNames)
    load = unittest.defaultTestLoader.loadTestsFromModule
    return unittest.TestSuite(map(load,modules))


#unittest.main(defaultTest = "regressionTest")

a = set([1,2])
print len(a)

filename = 'data/train_data.txt'
f = open(filename,'r')
count = 0
#str = '马航代表与乘客家属见面'.decode('utf-8')
w = np.linspace(1,4,6)
w = w / np.sum(w)
print w
for line in f:
    count+=1
    tcode = chardet.detect(line).get('encoding','utf-8')
    #print tcode
    line = line.decode(tcode,'ignore')
    column = line.split('\t')
    print tp.timestamp_datetime(int(column[2].strip()))
    print column[2] + ':' +column[5]
    if count > 1:
        break
f.close()

#second
a = numpy.array([[1,2],[3,4]])
print numpy_sigmoid(a)


c = 5.2 -6.5j
print c.real
print c.imag
print c

word = 'help' + 'A'
print word[:-2]
print word[-2:]

#third

train = [[[9,25],-1],[[5,8],-1],[[15,31],-1],[[35,62],-1],[[19,40],-1],[[28,22],1],[[20,5],1],[[19,11],1],[[25,8],1],[[33,17],1]]
myann = lc.LineClassifier()
myann.samples_init(train)
myann.r_init(50)
myann.maxtry_init(100)
myann.train()
print myann.simulate([5,9])
print myann.w

#jieba
seg = jieba.cut("我来到深圳", cut_all=True)
print "Full Mode:","/ ".join(seg)

seg = jieba.cut("我来到深圳", cut_all=False)
print "Default Mode:","/ ".join(seg)

seg = jieba.cut("我来到深圳", cut_all=False)
print ", ".join(seg)

seg_list = jieba.cut_for_search("小明毕业于中国科学院，后在斯坦福大学深造") #search engine model
liststr = "/".join(seg_list)
f_stop = open("res/stopwords.txt")
try:
    f_stop_text = f_stop.read()
    f_stop_text = unicode(f_stop_text,'utf-8')
finally:
    f_stop.close()
f_stop_seg_list = f_stop_text.split('\n')
print f_stop_seg_list
for word in liststr.split('/'):    
    if not(word.strip() in f_stop_seg_list) and len(word.strip())>1:
        print word

#five
print 3.0/11
x = np.array([1,2])
y = np.array([3,4])

print sum(x*y)
print np.sum(x*y)**2

a = {}

a.setdefault("a",0)
print a
a["a"] = 1
a.setdefault("a",0)
a["a"]+=1
print a

print a.has_key('a')
