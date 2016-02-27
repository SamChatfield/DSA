type 'a btree =
    | Empty
    | Node of 'a * 'a btree * 'a btree

let left = function
    | Empty           -> failwith "No left of empty tree"
    | Node (_, l, _)  -> l

let right = function
    | Empty           -> failwith "No right of empty tree"
    | Node (_, _, r)  -> r

let root = function
    | Empty           -> failwith "No root of empty tree"
    | Node (r, _, _)  -> r

let isEmpty = function
    | Empty   -> true
    | Node _  -> false

let rec isHeap t = match t with
    | Empty                                                           -> true
    | Node _  when isEmpty (left t) && isEmpty (right t)              -> true
    | Node _  when isEmpty (left t) && root (right t) < root t        -> isHeap (right t)
    | Node _  when isEmpty (right t) && root (left t) < root t        -> isHeap (left t)
    | Node _  when root (left t) < root t && root (right t) < root t  -> isHeap (left t) && isHeap (right t)
    | _                                                               -> false

let t3 =
    Node(
        9,
        Node(
            3,
            Node(
                1,
                Empty,
                Empty
            ),
            Empty
        ),
        Node(
            2,
            Empty,
            Empty
        )
    )

let t4 =
    Node(
        6,
        Node(
            4,
            Node(
                5,
                Empty,
                Empty
            ),
            Empty
        ),
        Node(
            3,
            Empty,
            Empty
        )
    )
;;























































