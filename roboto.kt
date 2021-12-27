class roboto(var x: Int, var y: Int, var direction: Direction) {
    fun moveForward() {
        when (direction) {
            Direction.RIGHT -> x++
            Direction.LEFT -> x--
            Direction.UP -> y++
            Direction.DOWN -> y--
        }
    }

    fun turnLeft() {
        when (direction) {
            Direction.RIGHT -> direction = Direction.UP
            Direction.LEFT -> direction = Direction.DOWN
            Direction.UP -> direction = Direction.LEFT
            Direction.DOWN -> direction = Direction.RIGHT
        }
    }

    fun turnRight() {
        when (direction) {
            Direction.RIGHT -> direction = Direction.DOWN
            Direction.LEFT -> direction = Direction.UP
            Direction.UP -> direction = Direction.RIGHT
            Direction.DOWN -> direction = Direction.LEFT
        }
    }

    fun turnReverse() {
        when (direction) {
            Direction.RIGHT -> direction = Direction.LEFT
            Direction.LEFT -> direction = Direction.RIGHT
            Direction.UP -> direction = Direction.DOWN
            Direction.DOWN -> direction = Direction.UP
        }
    }

    override fun toString(): String {
        return "(${x}, ${y}), looks ${direction}"
    }
}

enum class Direction {
    UP, DOWN, LEFT, RIGHT
}

fun moveRobot(r:roboto, toX:Int, toY:Int){
    val dx = toX - r.x
    val dy = toY - r.y

    if(dx>0){ for (i in 1..dx){
        when(r.direction){
            Direction.RIGHT -> r.moveForward()
            Direction.LEFT -> {r.turnReverse()
                r.moveForward()
            }
            Direction.UP -> {r.turnRight()
                r.moveForward()
            }
            Direction.DOWN -> {r.turnLeft()
                r.moveForward()
            }
        }
    }
    }

    if(dx<0){for (i in 1..dx*-1){
        when(r.direction){
            Direction.RIGHT -> {r.turnReverse()
                r.moveForward()
            }
            Direction.LEFT -> r.moveForward()
            Direction.UP -> {r.turnLeft()
                r.moveForward()
            }
            Direction.DOWN -> {r.turnRight()
                r.moveForward()
            }
        }
    }
    }

    if(dy>0){for (i in 1..dy){
        when(r.direction){
            Direction.RIGHT -> {r.turnLeft()
                r.moveForward()
            }
            Direction.LEFT -> {r.turnRight()
                r.moveForward()
            }
            Direction.UP -> r.moveForward()
            Direction.DOWN -> {r.turnReverse()
                r.moveForward()
            }
        }
    }
    }

    if(dy<0){for (i in 1..dy*-1){
        when(r.direction){
            Direction.RIGHT -> {r.turnRight()
                r.moveForward()
            }
            Direction.LEFT -> {r.turnLeft()
                r.moveForward()
            }
            Direction.UP -> {r.turnReverse()
                r.moveForward()}

            Direction.DOWN -> r.moveForward()
        }
    }
    }

    println("Go X=" + toX + " Y=" + toY)
}

fun main(){
    val r1 = roboto(3,4,Direction.UP)
    println(r1)
    moveRobot(r1, 2, 3)
    println(r1)
}
