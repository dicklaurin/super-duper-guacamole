isEven :: Int -> Bool
isEven x  | x == 0 = True
          | x == 1 = False
          | x == 2 = True
          | otherwise = isEven (x-2)

arithSeries :: Int -> Int -> Int
arithSeries 0 0 = 0
arithSeries 0 _ = 0
arithSeries _ 0 = 0
arithSeries x y  | x==y = x
                 | x < y = x 
                 | otherwise =  x + arithSeries (x-y) y

isSorted :: [Int] -> Bool
isSorted [] = True
isSorted [x] = True
isSorted (x:y:xs) | x > y = False
                  | otherwise = isSorted (y:xs)

interval :: Int-> Int -> [Int]
interval x y | x > y = []
             | x == y = [x]
             | otherwise = x : interval (x+1) y 


selectKsmallest :: Int -> [Int] -> Int
selectKsmallest _ [] = 0
selectKsmallest x ys | isSorted(ys) == True = returnnumber x ys
                     | otherwise = selectKsmallest x (sort ys) 

returnnumber :: Int -> [Int] -> Int
returnnumber x (y:ys) | x == 1 = y
                      | otherwise = returnnumber (x-1) ys

merge :: [Int] -> [Int] ->[Int]
merge [] xs = xs
merge xs [] = xs
merge (x : xs) (y : ys) | x < y = x : merge xs (y : ys)
                        | otherwise = y : merge (x : xs) ys

split :: [Int] -> ([Int], [Int])
split (x:y:[]) = ([x],[y])
split (x:[]) = ([x], [])
split (x:y:xs) = (x:xs1, y:xs2)
   where (xs1, xs2) = split xs

sort :: [Int]-> [Int]
sort [] = []
sort [x] = [x]
sort xs = merge (sort xs1) (sort xs2)
  where (xs1, xs2) = split xs