--a)
data MultTree a = Index a a ([MultTree a])|Daten  a deriving Show

t1 :: MultTree Int
t1= Index 3 42 ([Index 3 15([Daten 3, Daten 5, Daten 12]), Index 19 42 ([Daten 42, Daten 23])])

t2 :: MultTree Int
t2= Index 3 42 ([Index 3 15([Daten 3, Daten 5, Daten 12])])

--b)
verzweigungsgrad :: MultTree a ->Int
verzweigungsgrad (Daten _) = 1
verzweigungsgrad (Index  _ _ (xs))=(verzweigungsgradListe xs )+1


verzweigungsgradListe :: [MultTree a] ->Int
verzweigungsgradListe [] =0
verzweigungsgradListe (x:xs) = maxListe ((verzweigungsgrad x):(verzweigungsgradListe xs):[])

maxListe :: [Int] -> Int
maxListe []=0
maxListe (x:xs)      | x >= maxListe xs =x
                     |otherwise =maxListe xs

--c)                    
datenListe :: MultTree a ->[a]
datenListe (Daten a)=a:[]
datenListe (Index  _ _ (xs))=datenListeL xs


datenListeL :: [MultTree a]->[a]
datenListeL []=[]
datenListeL (x:xs)=((datenListe x)++(datenListeL xs ))

--d)
datenIntervalle :: MultTree Int -> MultTree Int
datenIntervalle (Daten x)=(Daten x)
datenIntervalle (Index _ _ [])=Index minBound maxBound []
datenIntervalle (Index x y xs)=(Index (minDataL xs) (maxDataL xs) (datenIntervalleL xs))

datenIntervalleL :: [MultTree Int] -> [MultTree Int]
datenIntervalleL []=[]
datenIntervalleL (x:xs) =((datenIntervalle x):(datenIntervalleL xs))

minListe :: [Int] -> Int
minListe [x]=x
minListe (x:xs)      | x <= minListe xs =x
 		     |otherwise =minListe xs

minData :: MultTree Int->Int
minData (Daten x)=x
minData (Index x y (z:xs))=minListe ((minData z):(minDataL (xs):[] ))

minDataL:: [MultTree Int]->Int
minDataL [] =maxBound
minDataL (x:xs) = minListe ((minData x):(minDataL xs):[])

maxData :: MultTree Int->Int
maxData (Daten x)=x
maxData (Index x y (z:xs))=maxListe ((maxData z):(maxDataL (xs)):[] )

maxDataL:: [MultTree Int]->Int
maxDataL [] =minBound
maxDataL (x:xs) = maxListe ((maxData x):(maxDataL xs):[])

--e)
contains :: Int -> MultTree Int -> Bool
contains _ (Index _ _ []) = False
contains x (Daten a) = a==x 
contains x (Index b c ys) = if (b<=x && x<=c) then containsIndex x ys else False

containsIndex :: Int -> [MultTree Int] -> Bool
containsIndex x [] = False
containsIndex x (y:ys) = contains x y || containsIndex x ys
